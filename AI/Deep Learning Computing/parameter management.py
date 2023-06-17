import torch
from torch import nn
net = nn.Sequential(
    nn.Linear(10,20),
    nn.ReLU(),
    nn.Linear(20,2)
)
X = torch.rand((20,10))
# print(X.shape)
# print(*[(name,param.shape) for name,param in net[0].named_parameters()])
# print(*[(name,param.shape) for name,param in net.named_parameters()])

def block1():
    return nn.Sequential(
        nn.Linear(10,20),
        nn.ReLU(),
        nn.Linear(20,10)
    )

def block2():
    net = nn.Sequential()
    for i in range(4):
        net.add_module(f'block{i}',block1())
    return net
rgnet = nn.Sequential(block2(),nn.Linear(10,2))
# print(rgnet[0][1][2].state_dict()['bias'])  # state_dict返回字典

def init_normal(net):
    if type(net) == nn.Linear:
        nn.init.normal_(net.weight,0,0.01)
        nn.init.zeros_(net.bias)

def init_constant(net):
    if type(net)==nn.Linear:
        nn.init.constant_(net.weight,1)
        nn.init.zeros_(net.bias)
def init_xavier(net):
    if type(net) == nn.Linear:
        nn.init.xavier_uniform_(net.weight)
        nn.init.zeros_(net.bias)
net = nn.Sequential(
    nn.Linear(2,5),
    nn.ReLU(),
    nn.Linear(5,4)
)
def my_init(net):
    if type(net) == nn.Linear:
        nn.init.normal_(net.weight,10,5)

net[0].apply(my_init)
# print(net[0].state_dict()['weight'].shape)
# weight的第一维度是输出，第二维度是输入，这个是方便矩阵运算的，我们在进行使用的时候直接按照最直观的方式来就行了

shared = nn.Linear(10,10)
sharedNet = nn.Sequential(
    nn.Linear(2,30),
    nn.ReLU(),
    nn.Linear(30,10),
    nn.ReLU(),
    shared,
    nn.ReLU(),
    nn.Linear(10,20),
    nn.ReLU(),
    nn.Linear(20,10),
    nn.ReLU(),
    shared,
    nn.Linear(10,1)
)

print(sharedNet[4].state_dict()['weight'] == sharedNet[10].state_dict()['weight'])
sharedNet[4].weight.data[0,0] = 100
print(sharedNet[4].state_dict()['weight'][0] == sharedNet[10].state_dict()['weight'][0])
# 这个例子表明第三个和第五个神经网络层的参数是绑定的。 它们不仅值相等，而且由相同的张量表示。 因此，如果我们改变其中一个参数，另一个参数也会
# 改变。 这里有一个问题：当参数绑定时，梯度会发生什么情况？ 答案是由于模型参数包含梯度，因此在反向传播期间第二个隐藏层 （即第三个神经网络层）
# 和第三个隐藏层（即第五个神经网络层）的梯度会加在一起。