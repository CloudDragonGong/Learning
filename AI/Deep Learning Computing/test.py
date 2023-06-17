import torch.nn as nn

# 创建一个父模块
class Net(nn.Module):
    def __init__(self):
        super(Net, self).__init__()
        self.block1 = nn.Linear(10, 20)
        self.block2 = nn.Linear(20, 30)

# 创建父模块对象
net = Net()

# 添加一个子模块
net.add_module('block3', nn.Linear(30, 40))

# 动态添加多个子模块
for i in range(4):
    net.add_module(f'block {i}', nn.Linear(40, 50))

# 打印父模块及其子模块
print(net)
