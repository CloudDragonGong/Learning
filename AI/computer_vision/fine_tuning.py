import os
import torch
import torchvision
from torch import nn
from d2l import torch as d2l

#@save
d2l.DATA_HUB['hotdog'] = (d2l.DATA_URL + 'hotdog.zip',
                         'fba480ffa8aa7e0febbb511d181409f899b9baa5')

data_dir =r'E:/repository/learning/data/hotdog'
train_img= torchvision.datasets.ImageFolder(os.path.join(data_dir,'train'))
test_img = torchvision.datasets.ImageFolder(os.path.join(data_dir,'test'))

train_imgs = [ train_img[i][0] for i in range(8)]
test_imgs = [test_img[-1- i][0] for i in range(8)] 

d2l.show_images(train_imgs+test_imgs,num_cols=8,num_rows=2,scale=1.5)
d2l.plt.show()

