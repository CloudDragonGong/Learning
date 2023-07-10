# *args和**wargs

[详解](https://blog.csdn.net/yuxin6866/article/details/75809590)

## 问题

~~~python
def __init__(self,output_filename,output_wav,voice_assistant_communication_queue=None,*args):
~~~

~~~python
assistant=IFlytek_assistant(r'voice/response.mp3',r'voice/response.wav',None,'垃圾桶的分类状况')
~~~

需要把诸如`information=information`去掉，不然就会报错相当于是说语法规范

