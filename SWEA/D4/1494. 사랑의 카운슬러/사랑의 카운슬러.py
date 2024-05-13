times = int(input())
for time in range(times):
    n=int(input())
    remain=[i for i in range(n)]
    nodes=[]
    for i in range(n):
        nodes.append(list(map(int,input().split())))

    ans=99999999999999999
    def cal(now):
        global ans
        a=[0,0]
        b=[0,0]
        for i,d in enumerate(now):
            if d==1:
                a[0]+=nodes[i][0]
                a[1]+=nodes[i][1]
            else:
                b[0]+=nodes[i][0]
                b[1]+=nodes[i][1]
        ans=min((a[0]-b[0])**2 + (a[1]-b[1])**2,ans)


    def perm(length,now,remain):
        if length==n/2:
            tmp=[0 for _ in range(n)]
            for i in now:
                tmp[i]=1
            cal(tmp)
            return

        for i in range(len(remain)):
            perm(length+1,now+[remain[i]],remain[i+1:])

    perm(0,[],remain)
    print("#{} {}".format(time+1,ans))

