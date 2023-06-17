import torch
from torch import nn
from d2l import torch as d2l

def pool2d(X,pool_size,mode='max'):
    Y = torch.zeros((X.shape[0]-pool_size[0]+1, X.shape[1]-pool_size[1]+1))
    for i in range(Y.shape[0]):
        for j in range(Y.shape[1]):
            if(mode=='max'):
                Y[i,j] = X[i:i+pool_size[0],j:j+pool_size[1]].max()
            elif (mode=='avg'):
                Y[i,j] = X[i:i+pool_size[0],j:j+pool_size[1]].mean()
    return Y

X = torch.tensor([[0.0, 1.0, 2.0], [3.0, 4.0, 5.0], [6.0, 7.0, 8.0]])
Y = pool2d(X, (2, 2), 'avg')
X = torch.arange(16,dtype=torch.float32).reshape((1,1,4,4))
print(X)
X = torch.cat((X,X+1),1)
print(X)
pool2d = nn.MaxPool2d((2, 3), stride=(2, 3), padding=(0, 1))
print(pool2d(X))


