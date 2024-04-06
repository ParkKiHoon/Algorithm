r,c,k=map(int,input().split())
r-=1
c-=1
board=[list(map(int,input().split())) for _ in range(3)]

clear=-1
for times in range(101):
    try:
        if board[r][c]==k:
            clear=times
            break
    except:
        pass
    if len(board)>=len(board[0]):#R연산
        total = []
        max_len=0
        for i in range(len(board)):
            arr = []
            tmp=list(set(board[i]))
            if 0 in tmp:
                tmp.remove(0)
            for j in tmp:
                arr.append((j,board[i].count(j)))
            arr.sort(key=lambda x:(x[1],x[0]))
            total.append(arr)
            max_len=max(max_len,len(arr)*2)
        for i in range(len(board)):
            inner_tmp=[]
            for j in total[i]:
                inner_tmp.append(j[0])
                inner_tmp.append(j[1])
            board[i] = inner_tmp+[0 for _ in range((max_len-len(inner_tmp)))]
    else:#C연산
        total = []
        max_len=0
        for i in range(len(board[0])):
            arr = []
            board2=[]
            for j in range(len(board)):
                board2.append(board[j][i])
            tmp=list(set(board2))
            if 0 in tmp:
                tmp.remove(0)
            for j in tmp:
                arr.append((j,board2.count(j)))
            arr.sort(key=lambda x:(x[1],x[0]))
            total.append(arr)
            max_len=max(max_len,len(arr)*2)
        board_tmp=len(board[0])
        del[board]
        board=[[0 for _ in range(board_tmp)] for _ in range(max_len)]
        for i in range(board_tmp):
            inner_tmp=[]
            for j in total[i]:
                inner_tmp.append(j[0])
                inner_tmp.append(j[1])
            collect = inner_tmp+[0 for _ in range((max_len-len(inner_tmp)))]
            for j in range(max_len):
                board[j][i]=collect[j]

print(clear)