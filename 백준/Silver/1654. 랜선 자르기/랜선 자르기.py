n,k = map(int,input().split())

board=[]
for i in range(n):
    board.append(int(input()))


high=sum(board)

low=1

def cond(val):
    cnt=0
    for i in board:
        cnt+= i//val
    return cnt

while True:
    if low>=high-1:
        break
    mid=int((low+high)/2)
    if cond(mid)>k-1:
        low=mid
    else:
        high=mid


print(low)