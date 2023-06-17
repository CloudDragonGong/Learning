import torch
from torch import nn
from d2l import torch as d2l

def corr2d(X,K):
    h,w  = K.shape
    Y = torch.zeros((X.shape[0]-h+1,X.shape[1]-w+1))
    for i in range(Y.shape[0]):
        for j in range(Y.shape[1]):
            Y[i,j] = (X[i:i+h,j:j+w] * K).sum()# 这里是二维数组，用嵌套数组是错误的
    return Y

def corr2d_(X, K):  #@save
    """计算二维互相关运算"""
    h, w = K.shape
    Y = torch.zeros((X.shape[0] - h + 1, X.shape[1] - w + 1))
    for i in range(Y.shape[0]):
        for j in range(Y.shape[1]):
            Y[i, j] = (X[i:i + h, j:j + w] * K).sum()
    return Y
X  = torch.ones((6,8))
X[:,2:6] = 0
print(f'X is {X} ')
Y = corr2d(X,torch.tensor([[1.0,-1.0]]))
print(f'Y is {Y}')
conv2d = nn.Conv2d(1,1,kernel_size=(1,2),bias=False)
def train(conv2d,X,Y,lr,epoch_nums):
    X = X.reshape((1,1,6,8))
    Y = Y.reshape((1,1,6,7))
    # 这两个不要忘记
    for epoch in range(epoch_nums):
        Y_hat = conv2d(X)
        l = (Y_hat-Y) ** 2
        conv2d.zero_grad()
        l.sum().backward()
        conv2d.weight.data -= lr*conv2d.weight.grad
        if epoch % 2 ==0:
            print(f'epoch {epoch} , loss {l.sum()}')
train(conv2d,X,Y,3e-2,10)
print(conv2d.weight.data.reshape(-1,2))
