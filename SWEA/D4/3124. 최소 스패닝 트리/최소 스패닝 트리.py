times = int(input())
for time in range(times):
    V,E=map(int,input().split())
    nodes=[i for i in range(V+1)]
    edges=[]
    for i in range(E):
        A,B,C=map(int,input().split())
        edges.append([C,A,B])
    edges.sort(key=lambda x:(x[0],x[1],x[2]))

    def find_parent(arr,x):
        if arr[x]==x: return x
        else: return find_parent(arr,arr[x])

    cnt=0
    for C,A,B in edges:
        a=find_parent(nodes,A)
        b=find_parent(nodes,B)
        if a!=b:
            if a<b:
                nodes[b]=a
            else:
                nodes[a]=b
            cnt+=C

    print("#{} {}".format(time+1,cnt))
