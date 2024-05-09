times = int(input())
for time in range(times):
    n=int(input())
    sign=1
    cnt=0
    if n<2:
        sign=0
    else:
        while n!=1:
            if sign==1:
                if cnt==0:
                    if n%2==0:
                        n=(n+2)//2
                        sign=0
                    else:
                        n=(n+1)//2
                        sign=0
                else:
                    if n%2==0:
                        n=(n)//2
                        sign=0
                    else:
                        n=(n+1)//2
                        sign=0
            else:
                n=(n)//2
                sign=1
            cnt+=1
    print("#{} {}".format(time+1,"Bob" if sign==0 else "Alice"))