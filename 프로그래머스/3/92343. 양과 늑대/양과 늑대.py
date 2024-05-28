ans=[]
def solution(info, edges):
    visited=[0 for _ in range(len(info))]
    visited[0]=1
    
    def dfs(sheep,wolf):
        if wolf>=sheep:
            return
        ans.append(sheep)
        for edge in edges:
            a,b=edge
            if visited[a]==1 and visited[b]==0:
                visited[b]=1
                dfs(sheep,wolf+1) if info[b] else dfs(sheep+1,wolf)
                visited[b]=0
            
    dfs(1,0)

    return max(ans)