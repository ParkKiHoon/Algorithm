maxVal=-1
def solution(N, info):
    hint=[i+1 for i in info]
    arr=[0 for i in info]
    ans=[0 for i in info]
    def isWin(lion):
        total=0
        for i in range(0,11):
            if info[i]>0 and info[i]>=lion[i]:
                total-=(10-i)
            elif lion[i]>0 and info[i]<lion[i]:
                total+=(10-i)
        if total>0:
            return total
        else:
            return 0
    def dfs(arr,n,cnt):
        global maxVal
        if n==11:
            sumval=sum(arr)
            total=isWin(arr)
            if total and sumval<=N:
                arr[10]+=(N-sumval)
                if total>maxVal:
                    for i in range(len(ans)):
                        ans[i]=arr[i]
                    maxVal=total
                elif total==maxVal:
                    for i in range(10,-1,-1):
                        if len(ans)>0 and ans[i]>arr[i]:
                            return
                        elif len(ans)>0 and ans[i]<arr[i]:
                            for j in range(len(ans)):
                                ans[j]=arr[j]
                            maxVal=total
                            return

            return
        
        arr[n]=hint[n]
        dfs(arr,n+1,cnt+hint[n])

        arr[n]=0
        dfs(arr,n+1,cnt+hint[n])
            
    dfs(arr,0,0)
    print(ans)
    return ans if maxVal!=-1 else [-1]