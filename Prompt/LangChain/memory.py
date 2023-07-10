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
