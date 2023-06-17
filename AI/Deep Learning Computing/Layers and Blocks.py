import torch
from torch import nn
from torch.nn import functional as F

net = nn.Sequential(nn.Linear(10,100) ,nn.ReLU(),nn.Linear(100,1))
X = torch.rand((10,10))
class MLP(nn.Module):
    def __init__(self):
        super().__init__()
        self.hidden = nn.Linear(10,100)
        self.out = nn.Linear(100,1)

    def forward(self,X):
        return self.out(F.relu(self.hidden(X)))

net = MLP()


class MySequential(nn.Module):
    def __init__(self,*args):
        super().__init__()
        for index , module in enumerate(args):# 这里注意不要少了enumerate
            self._modules[str(index)] = module
    def forward(self,X):
        for module in self._modules.values():
            X = module(X)
        return X


net = MySequential(nn.Linear(10,100) ,nn.ReLU(),nn.Linear(100,1))
print(net)
print(net(X))



class MySequential_test(nn.Module):
    def __init__(self,*args):
        super().__init__()
        self.my_modules = []  # 改成列表也没问题
        for index , module in enumerate(args):
            self.my_modules.append(module)

    def forward(self,X):
        for module in self.my_modules:
            X = module(X)
        return X

net = MySequential_test(nn.Linear(10,100) ,nn.ReLU(),nn.Linear(100,1))
print(net)# _module主要作用在这
print(net(X))
