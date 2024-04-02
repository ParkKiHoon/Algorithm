n,l=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(n)]
def test(arr):
    visited = [0] * n
    for i in range(0,n-1):
        if arr[i]!=arr[i+1]:
            if abs(arr[i]-arr[i+1])>1:
                return 0
            else:
                if arr[i]>arr[i+1]:
                    if i+l+1>n:
                        return 0
                    cur=arr[i+1]
                    for j in range(i+1,i+1+l):
                        if visited[j] or arr[j]!=cur:
                            return 0
                        visited[j]=1

                elif arr[i]<arr[i+1]:
                    if i-l+1<0:
                        return 0
                    cur=arr[i]
                    for j in range(i,i-l,-1):
                        if visited[j] or arr[j]!=cur:
                            return 0
                        visited[j]=1
    return 1

cnt=0
for i in range(n):
    cnt+=test(board[i])
    cnt+=test(list(board[k][i] for k in range(n)))

print(cnt)