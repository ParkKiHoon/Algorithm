n=int(input())
arr=[5000]*5001
arr[3]=1
arr[5]=1
for i in range(6,n+1):
    arr[i]=min(arr[i-3],arr[i-5])+1

print(arr[n] if arr[n]<5000 else -1)