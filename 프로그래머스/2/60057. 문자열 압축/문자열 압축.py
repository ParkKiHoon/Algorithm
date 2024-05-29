def solution(s):
    L=len(s)
    answer=9999999999
    if L==1:
        return 1
    for cut in range(1,L//2+1):
        tmp=s[0:cut]
        cnt=1
        ans=""
        
        for i in range(cut,L,cut):
            now=None
            try:
                now=s[i:i+cut]
            except:
                now=s[i:]

            if tmp==now:
                cnt+=1
            else:
                if cnt==1:
                    ans+=tmp
                else:
                    ans+=str(cnt)+tmp
                tmp=now
                cnt=1
        if cnt>1:

            answer=min(answer,len(ans+str(cnt)+tmp))
        else:
            answer=min(answer,len(ans+tmp))


    return answer