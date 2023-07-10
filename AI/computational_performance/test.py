import torch
data1= torch.tensor(
    [
        [1,2,3],
        [4,5,6]
    ]
)
print(f'before caculating data is :{data1}')
for i in range(len(data1)):
    data1[0][:]+=data1[i][:]
print(f'after caculating data is : {data1}')