def solution(edges):
    n=0
    for i in edges:
        n=max(n,i[0],i[1])
    nodes_in=[[] for _ in range(n+1)]
    nodes_out=[[] for _ in range(n+1)]
    added_node=(0,0)
    
    for i in edges:
        nodes_in[i[0]].append(i[1])
        nodes_out[i[1]].append(i[0])
        
    ans=[0,0,0]
    for i in range(1,n+1):
        if len(nodes_in[i])==2 and len(nodes_out[i])>=2:
            ans[2]+=1
        elif len(nodes_in[i])==0 and len(nodes_out[i])>=1:
            ans[1]+=1
        elif len(nodes_in[i])>=2 and len(nodes_out[i])==0:
            added_node=(i,len(nodes_in[i]))
    
    return [added_node[0],added_node[1]-ans[1]-ans[2],ans[1],ans[2]]