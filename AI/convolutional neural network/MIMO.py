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
def corr2d_multi_in(X,K):
    return sum(corr2d(x,k) for x ,k in zip(X,K))

X = torch.tensor([[[1,2,3],[4,5,6],[7,8,9]],[[0,1,2],[3,4,5],[6,7,8]]])
K = torch.tensor([[[1,2],[3,4]],[[0,1],[2,3]]])

def corr2d_multi_in_out(X,K):
    return torch.stack([corr2d_multi_in(X,k) for k in K],0)

K = torch.stack((K,K+1,K+2),0)

def corr2d_multi_in_out_1x1(X,K):
    c_i , h ,w = X.shape
    X = X.reshape((c_i,h*w))
    c_o = K.shape[0]
    K = K.reshape(c_o,c_i)
    Y = torch.matmul(K,X)
    return Y.reshape(c_o,h*w)

X = torch.normal(0,1,(3,3,3))
K = torch.normal(0,1,(2,3,1,1))
Y1= corr2d_multi_in_out_1x1(X,K)
Y2= corr2d_multi_in_out(X,K)
print(abs(Y1.sum()-Y2.sum())<1e-6)
