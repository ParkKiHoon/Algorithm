def solution(queue1, queue2):
    from collections import deque
    queue1=deque(queue1)
    queue2=deque(queue2)
    sum1=sum(queue1)
    sum2=sum(queue2)
    for i in range(0,len(queue1)*3):
        if sum1==sum2:
            return i
        elif sum1<sum2:
            tmp=queue2.popleft()
            queue1.append(tmp)
            sum1+=tmp
            sum2-=tmp
        elif sum1>sum2:
            tmp=queue1.popleft()
            queue2.append(tmp)
            sum2+=tmp
            sum1-=tmp
    return -1
