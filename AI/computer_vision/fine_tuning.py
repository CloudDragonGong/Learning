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

# 展示图片
# d2l.show_images(train_imgs+test_imgs,num_cols=8,num_rows=2,scale=1.5)
# d2l.plt.show()

normalize=torchvision.transforms.Normalize([0.485,0.456,0.406],[0.229,0.224,0.225])

train_augs = torchvision.transforms.Compose(
    [
        torchvision.transforms.RandomResizedCrop(224),
        torchvision.transforms.RandomVerticalFlip(),
        torchvision.transforms.ToTensor(),
        normalize
    ]
)


test_augs = torchvision.transforms.Compose(
    [
        torchvision.transforms.RandomResizedCrop([256,256]),
        torchvision.transforms.CenterCrop(224),
        torchvision.transforms.ToTensor(),
        normalize
    ]
)

pretrained_net= torchvision.models.resnet18(pretrained=False)
pretrained_net.load_state_dict(torch.load(r"E:/repository/learning/models/resnet18-5c106cde.pth"))
print(pretrained_net.fc)
fine_tuning_net=pretrained_net
nn.init.xavier_uniform_(fine_tuning_net.fc.weight)


def train_fine_tuning(net,learninng_rate,batch_size,num_epoch,param_group=True):
    train_iter = torchvision.datasets.ImageFolder(os.path.join(data_dir,'train'),transform=train_augs)
    test_iter = torchvision.datasets.ImageFolder(os.path.join(data_dir,'test'),transform=)