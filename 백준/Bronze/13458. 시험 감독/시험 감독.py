import math
n= input()
a=list(map(int,input().split()))
b,c=map(int,input().split())


for i,d in enumerate(a):
    a[i]-=b
    if a[i]<0:
        a[i]=0

cnt=0
for i in a:
    cnt+=math.ceil(i/c)

print(len(a)+cnt)