def solution(today, terms, privacies):
    year,month,day=map(int,today.split("."))
    today=28*12*year + 28*month + day
    exp={}
    for i in terms:
        a,b=i.split()
        exp[a]=int(b)*28
    ans=[]
    
    for index,i in enumerate(privacies):
        ymd,e=i.split(" ")
        y,m,d=map(int,ymd.split("."))
        t=28*12*y + 28*m + d-1
        if t+exp[e]<today:
            ans.append(index+1)
        
    return ans