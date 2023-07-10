# Prompting

## Setup

~~~python
import openai
import os

from dotenv import load_dotenv, find_dotenv
_ = load_dotenv(find_dotenv())

openai.api_key  = os.getenv('OPENAI_API_KEY')
~~~

其中key要到官网拿到

~~~python
def get_completion(prompt, model="gpt-3.5-turbo"):
    messages = [{"role": "user", "content": prompt}]
    response = openai.ChatCompletion.create(
        model=model,
        messages=messages,
        temperature=0, # this is the degree of randomness of the model's output
    )
    return response.choices[0].message["content"]
~~~

加载模型，这个怎么实现不用管

## Prompting Principles

 ```, """, < >, `<tag> </tag>`, `:`  ，用这些东西分割开

~~~
text = f"""
You should express what you want a model to do by \ 
providing instructions that are as clear and \ 
specific as you can possibly make them. \ 
This will guide the model towards the desired output, \ 
and reduce the chances of receiving irrelevant \ 
or incorrect responses. Don't confuse writing a \ 
clear prompt with writing a short prompt. \ 
In many cases, longer prompts provide more clarity \ 
and context for the model, which can lead to \ 
more detailed and relevant outputs.
"""
prompt = f"""
Summarize the text delimited by triple backticks \ 
into a single sentence.
```{text}```
"""
response = get_completion(prompt)
print(response)
~~~

## inferring

- split

`response.split(sep=',')` 是一个字符串的方法，用于将字符串按照指定的分隔符 `','` 进行拆分，并返回一个拆分后的子字符串列表。

~~~python
prompt = f"""
Determine five topics that are being discussed in the \
following text, which is delimited by triple backticks.

Make each item one or two words long. 

Format your response as a list of items separated by commas.

Text sample: '''{story}'''
"""
response = get_completion(prompt)
print(response)
~~~

~~~python
response.split(sep=',')
~~~

~~~python
['government survey',
 ' job satisfaction',
 ' NASA',
 ' Social Security Administration',
 ' employee concerns']
~~~

- join
  - `topic_list` 是一个包含多个主题的列表。
  - `", ".join(topic_list)` 是使用 `join()` 方法将列表中的元素拼接成一个字符串。`", "` 是指定的分隔符，表示在每个主题之间插入逗号和空格。
  - 最终结果会是一个以逗号和空格分隔的字符串，其中包含了列表中的所有主题

~~~python
topic_list = [
    "nasa", "local government", "engineering",
    "employee satisfaction", "federal government"
]
result = ", ".join(topic_list)
print("List of topics: " + result)

~~~

~~~shell
List of topics: nasa, local government, engineering, employee satisfaction, federal government

~~~

>这一节就是讲了我们可以通过大语言模型来进行文本推理，讲了一下效果而已。

## Transforming

这一节讲了

- 如何用api进行翻译工作，还可以翻译为不同的语气，是否正式

- 将文件类型进行转换

  ~~~python
  from IPython.display import display, Markdown, Latex, HTML, JSON
  display(HTML(response))
  ~~~

- 检查语法

## Expanding

讲了怎么自动生成电子邮件

## Chatbot

~~~python
def get_completion(prompt, model="gpt-3.5-turbo"):
    messages = [{"role": "user", "content": prompt}]
    response = openai.ChatCompletion.create(
        model=model,
        messages=messages,# messages 是字典组成的列表，每个字典是一次对话，然后对话是有								顺序的，然后返回的是assistant的回答
        temperature=0, # this is the degree of randomness of the model's output
        # 如果靠近1，那么就更有创造性，如果靠近0，那么就更加保守
    )
    return response.choices[0].message["content"]

def get_completion_from_messages(messages, model="gpt-3.5-turbo", temperature=0):
    response = openai.ChatCompletion.create(
        model=model,
        messages=messages,
        temperature=temperature, # this is the degree of randomness of the model's output
    )
#     print(str(response.choices[0].message))
    return response.choices[0].message["content"]
~~~

~~~python
messages =  [  
{'role':'system', 'content':'You are friendly chatbot.'},
{'role':'user', 'content':'Hi, my name is Isa'},
{'role':'assistant', 'content': "Hi Isa! It's nice to meet you. \
Is there anything I can help you with today?"},
{'role':'user', 'content':'Yes, you can remind me, What is my name?'}  ]
response = get_completion_from_messages(messages, temperature=1)
print(response)
~~~

~~~shell
Your name is Isa.
~~~

> 在对话系统中，'role' 表示消息的角色，通常有以下三种角色：
>
> 1. 'system'（系统）：该角色用于向用户提供一些系统级别的信息或指示。例如，在对话开始时，系统可以向用户介绍助手的功能或提示用户如何与助手进行交互。
>
> 2. 'user'（用户）：该角色表示用户发送的消息或输入。用户角色用于表示用户与助手进行对话时的发言。
>
> 3. 'assistant'（助手）：该角色表示助手的回复或响应消息。助手角色用于表示对用户的回答、建议、解释或执行操作等。
>
> 这些角色的定义是一种常见的对话模型设计约定，用于区分不同参与者的发言。它们有助于对话系统理解和生成对话上下文，并提供合适的回复。
>
> 在特定的对话系统中，可以根据需要自定义其他角色或更多细分的角色。但在通常情况下，这三种角色已经涵盖了大部分对话场景的需求。
>
> 需要注意的是，对话系统的角色并非固定不变的，而是根据对话的上下文和场景进行动态调整的。在不同的对话阶段或任务中，角色可能会有所变化。
>

