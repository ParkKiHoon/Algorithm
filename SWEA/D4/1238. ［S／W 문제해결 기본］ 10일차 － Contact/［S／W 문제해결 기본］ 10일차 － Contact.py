import copy

times = 10
for time in range(times):
    n,m=map(int,input().split())
    board=list(map(int,input().split()))
    graph=[list()for _ in range(101)]
    visited=[0 for _ in range(101)]
    for i in range(0,n,2):
        if board[i+1] not in graph[board[i]]:
            graph[board[i]].append(board[i+1])
    from collections import deque
    queue=deque()
    queue.append(m)
    visited[m]=1
    ans=0
    while queue:
        q=[]
        while queue:
            q.append(queue.popleft())

        tmp=0
        cnt=0
        for i in q:
            for j in graph[i]:
                if visited[j]==0:
                    cnt+=1
                    visited[j]=1
                    queue.append(j)
                    tmp=max(tmp,j)
        if cnt>0:
            ans=tmp

    print("#", time + 1," ", ans, sep="")