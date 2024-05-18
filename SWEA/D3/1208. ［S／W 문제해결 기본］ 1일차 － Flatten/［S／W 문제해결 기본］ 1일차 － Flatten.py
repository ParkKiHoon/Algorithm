times=10
for time in range(times):
    n=int(input())
    arr=list(map(int,input().split()))
    arr.sort()
    from collections import deque
    queue = deque(arr)
    for i in range(n):
        if queue[0]==queue[-1]:
            break
        leftValue=queue.popleft()
        rightValue=queue.pop()
        leftValue+=1
        rightValue-=1

        leftTmp=[]
        while queue[0]<leftValue:
            leftTmp.append(queue.popleft())
        queue.appendleft(leftValue)
        for i in leftTmp:
            queue.appendleft(i)

        rightTmp = []
        while queue[-1] > rightValue:
            rightTmp.append(queue.pop())
        queue.append(rightValue)
        for i in rightTmp:
            queue.append(i)

    print("#{} {}".format(time+1,queue[-1]-queue[0]))