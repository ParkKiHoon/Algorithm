times=int(input())
for time in range(times):
    n=int(input())
    board=[]
    for i in range(n):
        tmp=input()
        tmp_arr=[]
        for t in tmp:
            tmp_arr.append(int(t))
        board.append(tmp_arr)

    cnt=0
    length=n//2
    for i in range(-length,length+1):
        for j in range(-length,length+1):
            if abs(i)+abs(j)<=length:
                cnt+=board[length+i][length+j]

    print("#{} {}".format(time+1, cnt))