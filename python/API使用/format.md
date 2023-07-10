# format

> 能够实现插入将变量插入文本

~~~python
response =response.format(information=self.information)
~~~

~~~
# txt
我是一个人，你是吗？不是，我是{information[TotalNumber]}
# 在{}中，不需要引号来包裹key，直接写上去就可以自动解析
~~~

输出

~~~
我是一个人，你是吗？不是，我是0
~~~

> 当你使用 `{infomation['TotalNumber']}` 作为占位符时，Python 会尝试将其解析为一个变量，但由于该变量不存在，所以会导致 `KeyError` 错误。
>
> 如果你想要使用字典中的键名作为占位符，可以将占位符改为 `{information[TotalNumber]}`，这样 Python 会将 `information[TotalNumber]` 解析为字典中的键值。
>
> 注意，键名 `TotalNumber` 不需要使用引号包裹，因为在这个上下文中，它被解析为一个变量名而不是字符串