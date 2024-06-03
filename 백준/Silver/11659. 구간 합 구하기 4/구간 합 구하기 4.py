n,m= map(int,input().split())
list=list(map(int,input().split()))
sum=[0 for i in range(n+1)]
for i in range(1,n+1):
    sum[i]=list[i-1]+sum[i-1]

for i in range(m):
    a,b=map(int,input().split())
    print(sum[b]-sum[a-1])