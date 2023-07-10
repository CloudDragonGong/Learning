import torch
import torchvision 
from torch import nn
from d2l import torch as d2l
d2l.set_figsize()
img = d2l.Image.open(r'E:/repository/learning/data/img/1.jpg')
# d2l.plt.imshow(img)
# # d2l.plt.show()
# d2l.plt.pause(10)
def apply(img,aug,num_row=2,num_col=4,scale=1.5):
    Y = [aug(img) for _ in range(num_row*num_col)]
    d2l.show_images(Y,num_row,num_col,scale=scale)
    d2l.plt.show()
apply(img,torchvision.transforms.RandomHorizontalFlip())
apply(img,torchvision.transforms.RandomVerticalFlip())
show_aug= torchvision.transforms.RandomResizedCrop((200,200),scale=(0.1,1),ratio=(0.5,2))
apply(img,show_aug)
apply(img,torchvision.transforms.ColorJitter(brightness=0.5,contrast=0,saturation=0,hue=0))
apply(img,torchvision.transforms.ColorJitter(hue=0.5))