import math

times = int(input())
for time in range(times):
    n = int(input())
    nodes=[]
    node=[]
    val_x=list(map(int, input().split()))
    val_y=list(map(int, input().split()))
    for i in range(n):
        nodes.append((val_x[i],val_y[i]))
        node.append(i)
    weight=float(input())
    edges=[]
    for i in range(n):
        for j in range(n):
            if i!=j:
                length = (nodes[j][0]-nodes[i][0])**2+(nodes[j][1]-nodes[i][1])**2
                edges.append((i,j,weight * length))
    edges.sort(key=lambda x:(x[2],x[0],x[1]))
    total=0
    def find_parent(node,x):
        if node[x]!=x:
            node[x]=find_parent(node,node[x])
        return node[x]

    def union_parent(node,a,b):
        a=find_parent(node,a)
        b=find_parent(node,b)
        if a<b:
            node[b]=a
        else:
            node[a]=b
    for i in edges:
        a,b,cost=i
        if find_parent(node,a)!= find_parent(node,b):
            union_parent(node,a,b)
            total+=cost
    print("#",time+1, " ", round(total),sep="")