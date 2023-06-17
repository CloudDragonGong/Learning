import torch
X = torch.normal(0,1,(10,2))
print(X)
print(X[1:5,:])
print(X[1:5,:].shape)