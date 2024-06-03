def solution(board, skill):
    r,c=len(board),len(board[0])
    print(r,c)
    tmp=[[0 for _ in range(c+1)] for _ in range(r+1)]
    for i in skill:
        type,r1,c1,r2,c2,degree=i
        if type==1:
            tmp[r1][c1]-=degree
            tmp[r1][c2+1]+=degree
            tmp[r2+1][c1]+=degree
            tmp[r2+1][c2+1]-=degree
        if type==2:
            tmp[r1][c1]+=degree
            tmp[r1][c2+1]-=degree
            tmp[r2+1][c1]-=degree
            tmp[r2+1][c2+1]+=degree

    for j in range(r+1):
        for i in range(c+1):
            if i>0:
                tmp[j][i]+=tmp[j][i-1]
     
    for j in range(c+1):
        for i in range(r+1):
            if i>0:
                tmp[i][j]+=tmp[i-1][j]

    ans=0
    for i in range(r):
        for j in range(c):
            if board[i][j]+tmp[i][j]>0:
                ans+=1
    return ans