import torch
from torch import nn
from torch.nn import functional as F
x = torch.arange(4)
torch.save(x,'x-file')
x2 = torch.load('x-file')# x-file是二进制文件
print(x2)
y = torch.zeros(4)
print(y)
torch.save([x,y],'[x-y]-file')
print(torch.load('[x-y]-file'))
mydict = {'x': x , 'y':y}
torch.save(mydict,'mydict-file')
print(torch.load('mydict-file'))


class MLP(nn.Module):
    def __init__(self):
        super().__init__()
        self.hidden = nn.Linear(20,256)
        self.output = nn.Linear(256,1)

    def forward(self,X):
        return self.output(F.relu(self.hidden(X)))
X = torch.rand((2,20))
net = MLP()
y1 = net(X)
torch.save(net.state_dict(),'net_file.params')
clone = MLP()
clone.load_state_dict(torch.load('net_file.params'))
y2 = clone(X)
print(y1==y2)