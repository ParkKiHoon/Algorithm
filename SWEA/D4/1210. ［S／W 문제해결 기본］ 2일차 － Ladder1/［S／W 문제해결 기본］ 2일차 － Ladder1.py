times = 10
for time in range(times):
    input()
    arr = []
    for i in range(100):
        arr.append(list(map(int, input().split())))
    x, y = 0, 0
    for i in range(100):
        for j in range(100):
            if arr[i][j] == 2:
                x = i
                y = j

    while True:
        if 0 <= y - 1 and arr[x][y - 1] == 1:
            while True:
                if 0<= y-1 and arr[x][y-1]==1:
                    y-=1
                else:
                    break
        elif y + 1 < 100 and arr[x][y + 1] == 1:
            while True:
                if y + 1 < 100 and arr[x][y + 1] == 1:
                    y +=1
                else:
                    break
        x -= 1
        if x == 0:
            break

    print("#", time + 1, " ", y, sep="")
