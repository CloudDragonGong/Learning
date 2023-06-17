import torch
from torch import nn
import torch.nn.functional as F

class CenteredLayer(nn.Module):
    def __init__(self):
        super().__init__()

    def forward(self,X):
        return X - X.mean()#将X矩阵的所有元素都进行了平均

net = nn.Sequential(
    nn.Linear(10,20),
    CenteredLayer(),#实例化对象
)
Y = net(torch.rand((20,10)))
print(Y.mean())

# 自定义层
class MyLinear(nn.Module):
    def __init__(self,in_unit,unit):
        super().__init__()
        self.weight = nn.Parameter(torch.rand(in_unit,unit))
        self.bias = nn.Parameter(torch.rand(unit,))
    def forward(self,X):
        return F.relu(torch.matmul(X,self.weight.data) + self.bias.data)

net = nn.Sequential(
    nn.Linear(10,20),
    MyLinear(20,1)
)
X = torch.rand(10,10)
Y = net(X)
# print(Y)
# print(Y.shape)

# 快速判断张量shape的方法
# 输入，输出，没了


# 设计一个接受输入并计算张量降维的层
