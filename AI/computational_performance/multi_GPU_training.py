import torch
from torch import nn
from torch.nn import functional as F
from d2l import torch as d2l

scale = 0.01
W1 = torch.randn(size=(20, 1, 3, 3)) * scale
b1 = torch.zeros(20)
W2 = torch.randn(size=(50, 20, 5, 5)) * scale
b2 = torch.zeros(50)
W3 = torch.randn(size=(800, 128)) * scale
b3 = torch.zeros(128)
W4 = torch.randn(size=(128, 10)) * scale
b4 = torch.zeros(10)
params = [W1, b1, W2, b2, W3, b3, W4, b4]


def lenet(X, params):
    h1_conv = F.conv2d(input=X, weight=params[0], bias=params[1])
    h1_activation = F.relu(h1_conv)
    h1_pool = F.avg_pool2d(input=h1_activation, kernel_size=(2, 2), stride=(2, 2))
    h2_conv = F.conv2d(input=h1_pool, weight=params[2], bias=params[3])
    h2_activation = F.relu(h2_conv)
    h2_pool = F.avg_pool2d(input=h2_activation, kernel_size=(2, 2), stride=(2, 2))
    h2 = h2_pool.reshape(h2_pool.shape[0], -1)
    h3_linear = torch.mm(h2, params[4]) + params[5]
    h3 = F.relu(h3_linear)
    y_hat = torch.mm(h3, params[6]) + params[7]
    return y_hat


loss = nn.CrossEntropyLoss(reduction="none")


# 得到全是转换后的参数
def get_params(params, device):
    new_params = [p.to(device) for p in params]
    for p in new_params:
        p.requires_grad_()
    return new_params


#
def allreduce(data):
    for i in range(1, len(data)):
        data[0][:] += data[i].to(data[0].device)
    for i in range(1, len(data)):
        data[i][:] += data[0].to(data[i].device)


# 返回tensor列表的split数据结构的元组
def split_batch(X, y, devices):
    assert X.shape[0] == y.shape[0]
    return (nn.parallel.scatter(X, devices), nn.parallel.scatter(y, devices))


def train_batch(X, y, device_params, devices, lr):
    X_shards, y_shards = split_batch(X, y, devices)
    ls = [
        loss(lenet(X_shard, device_param), y_shard).sum()
        for X_shard, y_shard, device_param in zip(X_shards, y_shards, device_params)
    ]
    for l in ls:
        l.backward()
    with torch.no_grad():
        for i in range(len(device_params[0])):
            allreduce([device_params[c][i].grad for c in range(len(devices))])
    for params in device_params:
        d2l.sgd(params, lr, X.shape[0])


def train(num_gpus, batch_size, lr):
    train_iter, test_iter = d2l.load_data_fashion_mnist(batch_size=batch_size)
    devices = [d2l.try_gpu(i) for i in range(num_gpus)]
    device_params = [get_params(params=params, device=d) for d in devices]
    num_epoch = 10
    for i in range(num_epoch):
        for X, y in train_iter:
            train_batch(X, y, device_params, devices, lr)
            torch.cuda.synchronize()
        print(
            f"the accuracy of each epoch{i} in test_iter is {test(test_iter=test_iter,params=device_params[0])}"
        )
    print(f"the accuracy in test_iter totally is {test(test_iter=test_iter)}")


def test(test_iter, params):
    right_sum = 0
    num_y = 0
    for X, y in test_iter:
        y_hat = [lenet(X[i], params) for i in range(len(y))]
        right_sum += (y_hat == y).sum()
        num_y += len(y)
    return right_sum / num_y


train(1, 256, 0.2)
