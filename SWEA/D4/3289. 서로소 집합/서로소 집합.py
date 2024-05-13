times = int(input())
for time in range(times):
    n,m=map(int,input().split())
    arr=[i for i in range(n+1)]
    ans=""
    def find_parent(x):
        if arr[x]==x:
            return x
        else:
            return find_parent(arr[x])

    for i in range(m):
        order, a, b = map(int,input().split())
        if order:
            if find_parent(a)==find_parent(b):
                ans+="1"
            else:
                ans+="0"
        else:
            a=find_parent(a)
            b=find_parent(b)
            if a>b:
                arr[a]=b
            else:
                arr[b]=a
    print("#{} {}".format(time+1,ans))
    # 1 001
    # 1 001