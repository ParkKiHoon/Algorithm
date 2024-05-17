times = int(input())
for time in range(times):
    n = int(input())
    m = int(input())
    in_node=[[] for _ in range(n+1)]
    out_node=[[] for _ in range(n+1)]
    for i in range(m):
        a,b=map(int,input().split())
        in_node[b].append(a)
        out_node[a].append(b)


    def get_nodes(nodes,node):
        visited=[0 for _ in range(n+1)]
        stack=[node]
        while stack:
            now=stack.pop()
            for next in nodes[now]:
                if visited[next]==0:
                    visited[next]=1
                    stack.append(next)
        return visited.count(1)


    sol=0
    for i in range(1,n+1):
        if get_nodes(in_node,i)+get_nodes(out_node,i)+1==n:
            sol+=1

    print("#{} {}".format(time+1,sol))
