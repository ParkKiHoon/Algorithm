times = int(input())
for time in range(times):
    n=int(input())
    arr=[]
    for i in range(n):
        arr.append(input())
    arr=list(set(arr))
    arr.sort(key=lambda x:(len(x),x))
    print("#{}".format(time+1))
    for i in arr:
        print(i)
