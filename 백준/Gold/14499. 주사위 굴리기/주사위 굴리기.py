from collections import deque
n,m,r,c,k=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(n)]
order=list(map(int,input().split()))
order=deque(order)
dice=[0,0,0,0,0,0]
direct = { 1:[5,1,4,3,0,2] , 2:[4,1,5,3,2,0], 3:[3,0,1,2,4,5], 4:[1,2,3,0,4,5]}

def rolling(dice,dir):
    new_list=[]
    for i in direct[dir]:
        new_list.append(dice[i])
    return new_list

def position(r,c,dir):
    if dir==1:
        if c+1<m:
            c+=1
        else:
            return -1,-1

    elif dir==2:
        if c-1>=0:
            c-=1
        else:
            return -1,-1

    elif dir==3:
        if r-1>=0:
            r-=1
        else:
            return -1,-1

    elif dir==4:
        if r+1<n:
            r+=1
        else:
            return -1,-1

    return r,c

while order:
    q=order.popleft()
    temp_r,temp_c=position(r,c,q)
    if temp_r==-1 and temp_c==-1:
        continue
    else:
        r,c=temp_r,temp_c
        dice = rolling(dice, q)

    if board[r][c]==0:
        board[r][c]=dice[0]
    else:
        dice[0]=board[r][c]
        board[r][c]=0
    print(dice[2])

