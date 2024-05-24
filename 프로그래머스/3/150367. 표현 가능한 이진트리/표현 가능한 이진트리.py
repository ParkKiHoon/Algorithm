def dfs(number) :
    length = len(number)
    if  '1' not in number or '0' not in number:
        return 1
    
    mid = length // 2
    if number[mid] == '0':
        return 0
    
    return dfs(number[:mid]) and dfs(number[mid+1:])

def solution(numbers):
    sol=[]
    for i in numbers:
        tmp=bin(i)[2:]
        L=len(tmp)
        n=1
        while L>=n:
            n*=2
        tmp="0"*(n-L-1)+tmp
        sol.append(dfs(tmp))
        
    return sol