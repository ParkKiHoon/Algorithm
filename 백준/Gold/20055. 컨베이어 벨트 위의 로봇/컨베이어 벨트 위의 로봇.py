from collections import deque
queue=deque()
N,K=map(int,input().split())
for i in list(map(int,input().split())):
    queue.append(i)
robot=deque([0] * N*2)

cnt=1
while True:
    queue.rotate(1)
    robot.rotate(1)
    robot[N-1]=0
    for i in range(N-2,-1,-1):
        if robot[i]>0 and robot[i+1]==0 and queue[i+1]>0:
            robot[i+1]=robot[i]
            robot[i]=0
            queue[i+1]-=1
            if i==N-2:
                robot[i+1]=0
            elif i==0:
                robot[0]=0

    if queue[0]>0:
        robot[0]=1
        queue[0]-=1
    if queue.count(0)>=K:
        print(cnt)
        break
    cnt+=1

