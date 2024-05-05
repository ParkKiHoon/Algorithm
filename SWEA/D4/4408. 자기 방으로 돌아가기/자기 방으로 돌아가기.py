times = int(input())
for time in range(times):
    n=int(input())
    arr=[0 for _ in range(201)]
    for i in range(n):
        room=list(map(int,input().split()))
        room.sort()
        a=room[0]
        b=room[1]
        if a<b:
            c=(a+1)//2
            d=(b+1)//2
        else:
            c=(b+1)//2
            d=(a+1)//2
        for j in range(c,d+1):
            arr[j]+=1
    print("#", time + 1," ", max(arr), sep="")