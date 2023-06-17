import torch 
from torch import nn
from d2l import torch as d2l 

# net = nn.Sequential(
#     nn.Conv2d(1,6,kernel_size=(5,5),stride=1,padding=2),
#     nn.Sigmoid(),
#     nn.AvgPool2d(kernel_size=(2,2),stride=2),
#     nn.Conv2d(6,16,kernel_size=(5,5)),
#     nn.Sigmoid(),
#     nn.AvgPool2d(kernel_size=(2,2),stride=2),
#     nn.Flatten(),
#     nn.Linear(16*5*5,120),
#     nn.Sigmoid(),
#     nn.Linear(120,84),
#     nn.Sigmoid(),
#     nn.Linear(84,10),
#     nn.Sigmoid(),
# )
# net = nn.Sequential(
#     nn.Conv2d(1, 6, kernel_size=5, padding=2), nn.Sigmoid(),
#     nn.AvgPool2d(kernel_size=2, stride=2),
#     nn.Conv2d(6, 16, kernel_size=5), nn.Sigmoid(),
#     nn.AvgPool2d(kernel_size=2, stride=2),
#     nn.Flatten(),
#     nn.Linear(16 * 5 * 5, 120), nn.Sigmoid(),
#     nn.Linear(120, 84), nn.Sigmoid(),
#     nn.Linear(84, 10))

net = nn.Sequential(
    nn.Conv2d(1,6,kernel_size=(5,5),stride=1,padding=2),
    nn.ReLU(),
    nn.AvgPool2d(kernel_size=(2,2),stride=2),
    nn.Conv2d(6,16,kernel_size=(5,5)),
    nn.ReLU(),
    nn.AvgPool2d(kernel_size=(2,2),stride=2),
    nn.Flatten(),
    nn.Linear(16*5*5,120),
    nn.ReLU(),
    nn.Linear(120,84),
    nn.ReLU(),
    nn.Linear(84,10),
)

def train(net,train_iter,test_iter,lr,num_epoch,device):
    def init_weight(m):
        if type(m)==nn.Module or type(m) ==nn.Conv2d:
            nn.init.xavier_uniform_(m.weight)
    net.apply(init_weight)
    net.to(device)
    optimizer=torch.optim.SGD(net.parameters(),lr=lr)
    loss= nn.CrossEntropyLoss()
    net.train()
    for epoch in range(num_epoch):
        for X,y in train_iter:
            optimizer.zero_grad()
            X,y = X.to(device),y.to(device)
            ls = loss(net(X),y)
            ls.backward()
            optimizer.step()
        with torch.no_grad():
            print(f'epoch {epoch+1},loss {ls:.2f},test accuracy {test(net,test_iter=test_iter,device=device):.2f}')
    print(f'the final test accuracy is {test(net,test_iter=test_iter,device=device):.2f}')

        
def test(net,test_iter,device):
    num_total=0;
    num_equal=0;
    for X,y in test_iter:
        X,y = X.to(device),y.to(device)
        y_hat = net(X)
        y_hat = torch.argmax(y_hat,dim=1)
        num_equal+=(y_hat==y).type(torch.int).sum().item()
        num_total+=y.numel()
    return num_equal/num_total



if __name__ == '__main__':
    batch_size = 256
    train_iter , test_iter = d2l.load_data_fashion_mnist(batch_size=batch_size)
    train(net=net,test_iter=test_iter,train_iter=train_iter,num_epoch=50,device='cpu',lr=0.5)
    print(test(net,test_iter=test_iter,device='cpu'))
