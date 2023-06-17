import torch
from torch import nn

def com_conv2d(conv2d , X):
    X = X.reshape((1,1)+X.shape)
    Y = conv2d(X)
    return Y.reshape(Y.shape[2:])
conv2d1 = nn.Conv2d(1,1,kernel_size=(3,3),padding=1,stride=1)
conv2d2 = nn.Conv2d(1,1,kernel_size=3,padding=1,stride=2)
conv2d3 = nn.Conv2d(1,1,kernel_size=(3,5),padding=(0,1),stride=(3,4))
print(com_conv2d(conv2d1,torch.rand((8,8))).shape)
print(com_conv2d(conv2d2,torch.rand((8,8))).shape)
print(com_conv2d(conv2d3,torch.rand((8,8))).shape)

