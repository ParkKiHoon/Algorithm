
times = int(input())

def put(idx,left,right,p):
    global n,result,sum_weights

    if idx==n:
        result+=1
        return
    if left>sum_weights//2:
        result+=(2**(n-idx))
        return
    put(idx+1,left+p[idx],right,p)
    if right+p[idx]<=left:
        put(idx+1,left,right+p[idx],p)

def perm(length,now,remaining):
    global n
    if length==n:
        put(0,0,0,now)
        return
    for i in range(len(remaining)):
        perm(length+1,now+[remaining[i]],remaining[:i]+remaining[i+1:])

for time in range(times):
    n=int(input())
    weights=list(map(int,input().split()))
    sum_weights=sum(weights)
    result=0
    perm(0,[],weights)
    print("#{} {}".format(time+1,result))