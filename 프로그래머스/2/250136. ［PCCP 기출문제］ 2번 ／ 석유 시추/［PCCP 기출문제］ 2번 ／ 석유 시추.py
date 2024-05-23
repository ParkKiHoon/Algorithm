from collections import deque

def solution(land):
    visited=[[0 for i in range(len(land[0]))] for j in range(len(land))]
    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    sol=[0 for i in range(len(land[0]))]
    def bfs(x,y):
        visited[x][y]=1
        queue=deque()
        queue.append((x,y))
        count=0
        miny,maxy=y,y
        while queue:    
            ad=queue.popleft()
            #print(ad)
            #print(ad)
            count+=1
            #print(count)
            for i in range(0,4):
                x2=ad[0]+dx[i]
                y2=ad[1]+dy[i]
                #print(x2,y2,end=" ")
                if x2>=0 and x2<len(land) and y2>=0 and y2<len(land[0]):
                    if visited[x2][y2]==0 and land[x2][y2]==1:
                        visited[x2][y2]=1
                        queue.append((x2,y2))
                        miny=min(miny,y2)
                        maxy=max(maxy,y2)
                        #print(miny,maxy)
                        #print("CC")
        for i in range(miny,maxy+1):
            sol[i]+=count
        
    for i in range(len(land)):
        for j in range(len(land[0])):
            if land[i][j]==1 and visited[i][j]==0:
                bfs(i,j)
    #print(sol)
    answer = 0
    return max(sol)