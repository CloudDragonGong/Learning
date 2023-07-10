# Memory

<img src="Memory/image-20230627230001576.png" alt="image-20230627230001576" style="zoom:50%;" />

其实模型本身没有对话，只不过是每次输入的token用过langChain来进行提示的生成罢了

## 代码

### 安装

~~~python
pip install tiktoken
~~~



### ConversationBufferMemory

可以储存对话

~~~python
import os 
import langchain
from langchain.chat_models import ChatOpenAI
from langchain.chains import ConversationChain
from langchain.memory import ConversationBufferMemory
import warnings
warnings.filterwarnings('ignore')
langchain.debug=True
print(langchain.__version__)

llm = ChatOpenAI(temperature=0.0,openai_api_key='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')
memory = ConversationBufferMemory()
conversation = ConversationChain(
    llm=llm,
    memory=memory,
    verbose=True
)
memory.save_context({'input':'hi,my name is DragonGong'},{'output':'hello,Dragongong,my name is AI'})
memory.save_context({'input':'do you know 1+1=?'},{'output':'1+1=3'})
print(memory.buffer)
~~~

### ConversationBufferWindowMemory

~~~python

llm = ChatOpenAI(temperature=0.0,openai_api_key='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')
memory = ConversationBufferWindowMemory(k=1)
conversation = ConversationChain(
    llm=llm,
    memory=memory,
    verbose=False
)
# memory.save_context({'input':'hi,my name is DragonGong'},{'output':'hello,Dragongong,my name is AI'})
# memory.save_context({'input':'do you know 1+1=?'},{'output':'1+1=3'})
# memory.
print(conversation.predict(input='hi , my name is dragongong'))
print(conversation.predict(input='1+1=?'))
print(conversation.predict(input='do you know my name ?'))
# print(memory.buffer)
~~~

通过k的值来限制记忆的对话数量

### ConversationTokenBufferMemory

~~~python
import os 
import langchain
from langchain.chat_models import ChatOpenAI
from langchain.chains import ConversationChain
from langchain.memory import ConversationBufferMemory
from langchain.memory import ConversationBufferWindowMemory
from langchain.memory import ConversationTokenBufferMemory
from langchain.llms import OpenAI
import warnings
warnings.filterwarnings('ignore')
# langchain.debug=True
# print(langchain.__version__)

llm = ChatOpenAI(temperature=0.0,openai_api_key='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')
memory = ConversationTokenBufferMemory(llm=llm,max_token_limit=30)
conversation = ConversationChain(
    llm=llm,
    memory=memory,
    verbose=False
)
# memory.save_context({'input':'hi,my name is DragonGong'},{'output':'hello,Dragongong,my name is AI'})
# memory.save_context({'input':'do you know 1+1=?'},{'output':'1+1=3'})
# memory.
print(conversation.predict(input='hi , my name is dragongong'))
print(conversation.predict(input='1+1=?'))
print(conversation.predict(input='do you know my name ?'))
memory.load_memory_variables({})
~~~

限制字符数量

### ConversationSummaryMemory

~~~python
import os 
import langchain
from langchain.chat_models import ChatOpenAI
from langchain.chains import ConversationChain
from langchain.memory import ConversationBufferMemory
from langchain.memory import ConversationBufferWindowMemory
from langchain.memory import ConversationTokenBufferMemory
from langchain.memory import ConversationSummaryBufferMemory
from langchain.llms import OpenAI
import warnings
warnings.filterwarnings('ignore')
# langchain.debug=True
# print(langchain.__version__)

llm = ChatOpenAI(temperature=0.0,openai_api_key='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')
memory = ConversationSummaryBufferMemory(llm=llm,max_token_limit=100)
conversation = ConversationChain(
    llm=llm,
    memory=memory,
    verbose=False
)
# memory.save_context({'input':'hi,my name is DragonGong'},{'output':'hello,Dragongong,my name is AI'})
# memory.save_context({'input':'do you know 1+1=?'},{'output':'1+1=3'})
# memory.
print(conversation.predict(input='hi , my name is dragongong'))
print(conversation.predict(input='1+1=?'))
print(conversation.predict(input='do you know my name ?'))
print(memory.load_memory_variables({}))

~~~

总结性记忆，可以节省token的数量

## 报错

代码

~~~python
llm = ChatOpenAI(temperature=0.0,openai_api_key='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')
memory = ConversationBufferMemory()
conversation = ConversationChain(
    llm=llm,
    memory=memory,
    verbose=True
)
conversation.predict(input='1+1=?')
~~~

报错

~~~python
Error in on_chain_start callback: 'name'
Prompt after formatting:
The following is a friendly conversation between a human and an AI. The AI is talkative and provides lots of specific details from its context. If the AI does not know the answer to a question, it truthfully says it does not know.  

Current conversation:

Human: Hi,my name is Andrew
AI:

> Finished chain.
~~~

原因大致是 库的版本的原因，我感觉是只是支持jupyter notebook

两种解决方案

- 将verbose=true去掉

- 加上debug模式

  ~~~python
  langchain.debug=True
  ~~~

  
