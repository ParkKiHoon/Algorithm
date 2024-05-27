def solution(n, k):
    import math
    ans=0
    nVal=""
    while n>0:
        quo=n//k
        rem=n%k
        n=quo
        nVal+=str(rem)
    
    nVal=nVal[::-1]
    def isPrime(n):
        if n==1:
            return 0
        for i in range(2,int(math.sqrt(n))+1):
            if n%i==0:
                return 0
        return 1
    
    for i in nVal.split("0"):
        if i.isdigit() and isPrime(int(i)):
            ans+=1

        
    return ans