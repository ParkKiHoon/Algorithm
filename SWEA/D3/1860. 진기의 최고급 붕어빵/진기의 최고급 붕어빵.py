times=int(input())
from collections import deque
for time in range(times):
    N,M,K = map(int,input().split())
    customers=list(map(int,input().split()))
    customers.sort()
    signal=0
    for i,d in enumerate(customers):
        nokori=(d//M)*K-i
        if nokori-1<0:
            signal=1
            break

    if signal:
        print("#{} Impossible".format(time + 1))
    else:
        print("#{} Possible".format(time + 1))