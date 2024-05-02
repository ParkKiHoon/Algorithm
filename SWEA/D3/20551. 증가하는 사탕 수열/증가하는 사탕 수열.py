times = int(input())
for time in range(times):
    arr = list(map(int, input().split()))
    if arr[2] < 3 or arr[1]<2:
        print("#", time + 1, " ", -1, sep="")
        continue
    cnt = 0
    if arr[1] >= arr[2]:
        val = arr[1] - arr[2] + 1
        arr[1] -= val
        cnt += val
    if arr[0] >= arr[1]:
        val = arr[0] - arr[1] + 1
        arr[0] -= val
        cnt += val

    print("#", time + 1, " ", cnt, sep="")
