# parameter management

## 1.为什么weight矩阵和linear是相反的

~~~python
 nn.Linear(10,20), #torch.Size([5, 2])
~~~

> weight的第一维度是输出，第二维度是输入，这个是方便矩阵运算的，我们在进行使用的时候直接按照最直观的方式来就行了

## 2.快速判断张量shape的方法

> 输入，输出，没了
