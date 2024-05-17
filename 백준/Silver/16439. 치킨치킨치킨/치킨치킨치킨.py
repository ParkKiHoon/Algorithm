import itertools

N,M=map(int,input().split())
preferList=[list(map(int,input().split())) for _ in range(N)]
ans=0

def getPerferSum(now):
    global ans
    sum=0
    for i in preferList:
        max_tmp=0
        for j in now:
            max_tmp=max(max_tmp,i[j])
        sum+=max_tmp
    ans=max(ans,sum)

from itertools import combinations

list2=list(itertools.combinations([i for i in range(M)],3))
for i in list2:
    getPerferSum(i)


print(ans)