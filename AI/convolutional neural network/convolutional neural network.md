# convolutional neural network

## 二维数组和嵌套数组

在Python中，y[i, j]和`y[i][j]`表示对数组y进行索引的两种不同方式。

1. y[i, j]：这种索引方式适用于多维数组（例如NumPy数组），其中逗号用于分隔索引值。它表示对y的第i行和第j列进行索引，返回一个具体的元素值。

2. `y[i][j]`：这种索引方式适用于嵌套的一维数组或列表。它表示首先对y进行索引，获取y[i]处的元素（一个一维数组或列表），然后再对该一维数组或列表进行第二次索引，获取其中的第j个元素。

虽然这两种索引方式在某些情况下可能产生相同的结果，但它们的实际行为是不同的。

对于多维数组，使用y[i, j]通常更高效，因为它只需要一次索引操作即可获得目标元素。而使用`y[i][j]`需要进行两次索引操作，每次索引都会产生一个中间结果，可能会引入额外的开销。

对于嵌套的一维数组或列表，只能使用`y[i][j]`的方式进行索引，因为`y[i]`返回的是一个一维数组或列表，需要再次进行索引才能获得具体元素。

总之，使用y[i, j]对多维数组进行索引是更常用和高效的方式，而`y[i][j]`则适用于嵌套的一维数组或列表。

## X，Y的shape注意

~~~python
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

~~~

~~~python
# 动手学深度学习
# 构造一个二维卷积层，它具有1个输出通道和形状为（1，2）的卷积核
conv2d = nn.Conv2d(1,1, kernel_size=(1, 2), bias=False)

# 这个二维卷积层使用四维输入和输出格式（批量大小、通道、高度、宽度），
# 其中批量大小和通道数都为1
X = X.reshape((1, 1, 6, 8))
Y = Y.reshape((1, 1, 6, 7))
lr = 3e-2  # 学习率

for i in range(10):
    Y_hat = conv2d(X)
    l = (Y_hat - Y) ** 2
    conv2d.zero_grad()
    l.sum().backward()
    # 迭代卷积核
    conv2d.weight.data[:] -= lr * conv2d.weight.grad
    if (i + 1) % 2 == 0:
        print(f'epoch {i+1}, loss {l.sum():.3f}')
~~~

里面的

~~~python
X = X.reshape((1, 1, 6, 8))
Y = Y.reshape((1, 1, 6, 7))
~~~

很重要

## 填充padding

paddding指的是左右两边和上下两边都进行填充padding

~~~python
conv2d = nn.Conv2d(1,1,kernel_size=(3,3),padding=1,stride=1)
~~~

## [torch.stack的用法](https://zhuanlan.zhihu.com/p/354177500)

~~~python
import torch

T1 = torch.tensor([[1, 2, 3],
                   [4, 5, 6],
                   [7, 8, 9]])
# 假设是时间步T2
T2 = torch.tensor([[10, 20, 30],
                   [40, 50, 60],
                   [70, 80, 90]])

print(torch.stack((T1, T2), dim=0).shape)
print(torch.stack((T1, T2), dim=1).shape)
print(torch.stack((T1, T2), dim=2).shape)
print('1')
print(torch.stack((T1,T2),dim=0))
print('2')
print(torch.stack((T1,T2),dim=1))
print('3')
print(torch.stack((T1,T2),dim=2))
~~~

~~~shell
"D:\Program Files\Anaconda3-2023.03winx86\Anaconda3\envs\d2l\python.exe" "E:\repository\learning\Learning\AI\convolutional neural network\test.py" 
torch.Size([2, 3, 3])
torch.Size([3, 2, 3])
torch.Size([3, 3, 2])
1
tensor([[[ 1,  2,  3],
         [ 4,  5,  6],
         [ 7,  8,  9]],

        [[10, 20, 30],
         [40, 50, 60],
         [70, 80, 90]]])
2
tensor([[[ 1,  2,  3],
         [10, 20, 30]],

        [[ 4,  5,  6],
         [40, 50, 60]],

        [[ 7,  8,  9],
         [70, 80, 90]]])
3
tensor([[[ 1, 10],
         [ 2, 20],
         [ 3, 30]],

        [[ 4, 40],
         [ 5, 50],
         [ 6, 60]],

        [[ 7, 70],
         [ 8, 80],
         [ 9, 90]]])

进程已结束,退出代码0

~~~

## LeNet的train函数的loss下不去

初步判断是梯度消失和学习率太小了（开始的时候lr=0.1）

- 将lr调整为1，情况出现好转

  ~~~python
  epoch 1,loss 2.30,test accuracy 0.10
  epoch 2,loss 2.31,test accuracy 0.10
  epoch 3,loss 2.30,test accuracy 0.10
  epoch 4,loss 2.30,test accuracy 0.10
  epoch 5,loss 2.31,test accuracy 0.10
  epoch 6,loss 2.31,test accuracy 0.10
  epoch 7,loss 2.30,test accuracy 0.10
  epoch 8,loss 2.31,test accuracy 0.10
  epoch 9,loss 2.29,test accuracy 0.11
  epoch 10,loss 1.91,test accuracy 0.32
  epoch 11,loss 1.80,test accuracy 0.36
  epoch 12,loss 1.75,test accuracy 0.36
  epoch 13,loss 1.75,test accuracy 0.36
  ...
  ~~~

- 将激活函数改为ReLU情况变得更加糟糕,此时学习率为1

  ~~~python
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
  ~~~

  ~~~
  epoch 1,loss 2.31,test accuracy 0.10
  epoch 2,loss 2.30,test accuracy 0.10
  epoch 3,loss 2.30,test accuracy 0.10
  epoch 4,loss 2.30,test accuracy 0.10
  epoch 5,loss 2.30,test accuracy 0.10
  epoch 6,loss 2.30,test accuracy 0.10
  epoch 7,loss 2.30,test accuracy 0.10
  epoch 8,loss 2.31,test accuracy 0.10
  epoch 9,loss 2.30,test accuracy 0.10
  epoch 10,loss 2.31,test accuracy 0.10
  epoch 11,loss 2.30,test accuracy 0.10
  epoch 12,loss 2.31,test accuracy 0.10
  epoch 13,loss 2.31,test accuracy 0.10
  epoch 14,loss 2.31,test accuracy 0.10
  epoch 15,loss 2.31,test accuracy 0.10
  epoch 16,loss 2.30,test accuracy 0.10
  ~~~

- 将学习率改为0.5之后

  ~~~python
      train(net=net,test_iter=test_iter,train_iter=train_iter,num_epoch=50,device='cpu',lr=0.5)
  ~~~

  ~~~python
  epoch 1,loss 0.63,test accuracy 0.65
  epoch 2,loss 0.63,test accuracy 0.76
  epoch 3,loss 0.33,test accuracy 0.84
  epoch 4,loss 0.47,test accuracy 0.77
  epoch 5,loss 0.42,test accuracy 0.86
  epoch 6,loss 0.34,test accuracy 0.85
  ~~~

  赢了



最终成功的结果

~~~shell
(d2l) root@autodl-container-6b4f11a552-a6aafc1e:~/AI/convolutional neural network# python LeNet.py
epoch 1,loss 0.80,test accuracy 0.64
epoch 2,loss 0.38,test accuracy 0.78
epoch 3,loss 0.50,test accuracy 0.76
epoch 4,loss 0.41,test accuracy 0.81
epoch 5,loss 0.33,test accuracy 0.84
epoch 6,loss 0.34,test accuracy 0.82
epoch 7,loss 0.35,test accuracy 0.80
epoch 8,loss 0.26,test accuracy 0.87
epoch 9,loss 0.26,test accuracy 0.88
epoch 10,loss 0.21,test accuracy 0.87
epoch 11,loss 0.31,test accuracy 0.86
epoch 12,loss 0.26,test accuracy 0.84
epoch 13,loss 0.39,test accuracy 0.87
epoch 14,loss 0.28,test accuracy 0.86
epoch 15,loss 0.21,test accuracy 0.88
epoch 16,loss 0.18,test accuracy 0.89
epoch 17,loss 0.18,test accuracy 0.85
epoch 18,loss 0.22,test accuracy 0.89
epoch 19,loss 0.14,test accuracy 0.89
epoch 20,loss 0.17,test accuracy 0.88
epoch 21,loss 0.25,test accuracy 0.88
epoch 22,loss 0.23,test accuracy 0.86
epoch 23,loss 0.22,test accuracy 0.87
epoch 24,loss 0.19,test accuracy 0.87
epoch 25,loss 0.23,test accuracy 0.89
epoch 26,loss 0.14,test accuracy 0.89
epoch 27,loss 0.21,test accuracy 0.89
epoch 28,loss 0.11,test accuracy 0.88
epoch 29,loss 0.15,test accuracy 0.89
epoch 30,loss 0.24,test accuracy 0.89
epoch 31,loss 0.10,test accuracy 0.89
epoch 32,loss 0.13,test accuracy 0.88
epoch 33,loss 0.09,test accuracy 0.89
epoch 34,loss 0.09,test accuracy 0.89
epoch 35,loss 0.11,test accuracy 0.89
epoch 36,loss 0.09,test accuracy 0.90
epoch 37,loss 0.17,test accuracy 0.88
epoch 38,loss 0.11,test accuracy 0.89
epoch 39,loss 0.21,test accuracy 0.81
epoch 40,loss 0.12,test accuracy 0.89
epoch 41,loss 0.12,test accuracy 0.89
epoch 42,loss 0.11,test accuracy 0.89
epoch 43,loss 0.09,test accuracy 0.89
epoch 44,loss 0.12,test accuracy 0.89
epoch 45,loss 0.07,test accuracy 0.89
epoch 46,loss 0.14,test accuracy 0.89
epoch 47,loss 0.08,test accuracy 0.90
epoch 48,loss 0.10,test accuracy 0.89
epoch 49,loss 0.12,test accuracy 0.89
epoch 50,loss 0.11,test accuracy 0.89
the final test accuracy is 0.89
0.8914
~~~

