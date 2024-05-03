times = int(input())
for time in range(times):
    a,b,c=map(int,input().split())
    x=abs(a-(2*b-c))
    y=abs(b-(a+c)/2)
    z=abs(c-(2*b-a))

    print("#",time+1," ",round(float(min(x,y,z)),1),sep="")