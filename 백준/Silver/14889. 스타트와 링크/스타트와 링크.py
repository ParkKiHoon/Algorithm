import copy
import sys
from itertools import combinations
n=int(input())
arr=[list(map(int,input().split())) for _ in range(n)]
comb=list(combinations([i for i in range(n)], int(n/2)))
minval=sys.maxsize
for i in comb:
    pow1=0
    for k1 in i:
        for k2 in i:
            if k1!=k2:
                pow1+=arr[k1][k2]

    pow2=0
    new_one=[i for i in range(n)]
    for j in i:
        new_one.remove(j)
    for k1 in new_one:
        for k2 in new_one:
            if k1 != k2:
                pow2 += arr[k1][k2]

    minval=min(abs(pow1-pow2),minval)
print(minval)