import random
import torch
from torch.utils import data
from d2l import torch as d2l
from torch import nn;
def synthetic_date (w, b , num_examples):
    X = torch.normal(0,1,(num_examples,len(w)))
    y = torch.matmul(X,w)+b
    y += torch.normal(0,0.01,y.shape)
    return X , y.reshape((-1,1))

true_w = torch.tensor([2,-3.4])
true_b = 4.2
features, labels = synthetic_date(true_w,true_b,1000)
batch_size = 10


def load_array(data_arrays,batch_size,is_train=True):
    datasets = data.TensorDataset(*data_arrays)
    return data.DataLoader(datasets,batch_size,shuffle=is_train)
data_iter = load_array((features,labels),batch_size)
net = nn.Sequential(nn.Linear(2,1))
net[0].weight.data.normal_(0,0.01)
net[0].bias.data.fill_(0)
w = net[0].weight.data
b = net[0].bias.data
loss=nn.SmoothL1Loss()
trainer=torch.optim.SGD(net.parameters(),lr=0.03)
num_epoch = 30
for epoch in range(num_epoch):
    for X , y in data_iter:
        l = loss(net(X),y)
        trainer.zero_grad()
        l.backward()
        trainer.step()
    with torch.no_grad():
        print(f'epoch{epoch+1},loss{l:f}')
        print(f'grad of w {net[0].weight.grad}')
print(f'w的误差：{true_w - w.reshape(true_w.shape)}')
print(f'b的误差：{true_b - b.reshape((1))}')