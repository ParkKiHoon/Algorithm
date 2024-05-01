n=int(input())
for i in range(n):
    sum=0
    arr=list(map(int,input().split()))
    for j in arr:
        if j%2==1:
            sum+=j

    print("#",i+1," ",sum,sep="")
