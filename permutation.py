def perm(length,now,remaining):
    global n
    if length==n:
        print(now)
        return
    for i in range(len(remaining)):
        perm(length+1,now+[remaining[i]],remaining[:i]+remaining[i+1:])


n=int(input())
weights=list(map(int,input().split()))
sum_weights=sum(weights)
result=0
perm(0,[],weights)


# input
# 3
# 1 2 4

# output
# [1, 2, 4]
# [1, 4, 2]
# [2, 1, 4]
# [2, 4, 1]
# [4, 1, 2]
# [4, 2, 1]
