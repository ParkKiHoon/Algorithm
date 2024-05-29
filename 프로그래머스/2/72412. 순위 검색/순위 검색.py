
def solution(info, query):
    from bisect import bisect_left
    from bisect import bisect_right
    cond1=["cpp","java","python"]
    cond2=["backend","frontend"]
    cond3=["junior","senior"]
    cond4=["chicken","pizza"]
    dic={}
    ans=[]
    for c1 in cond1:
        for c2 in cond2:
            for c3 in cond3:
                for c4 in cond4:
                    dic[c1+"-"+c2+"-"+c3+"-"+c4]=[]
                    
    for i in info:
        c1,c2,c3,c4,score=i.split()
        dic[c1+"-"+c2+"-"+c3+"-"+c4].append(int(score))
    
    for i in dic:
        dic[i].sort()
        
    for q in query:
        c1,and1,c2,and2,c3,and3,c4,score=q.split()
        score=int(score)
        cond=""
        cnt=0
        for f1 in (cond1 if c1 =="-" else [c1]):
            for f2 in (cond2 if c2 =="-" else [c2]):
                for f3 in (cond3 if c3 =="-" else [c3]):
                    for f4 in (cond4 if c4 =="-" else [c4]):
                        tmp=dic[f1+"-"+f2+"-"+f3+"-"+f4]
                        cnt+=len(tmp)-bisect_left(tmp,score)
                        
                        
        ans.append(cnt)
                
    return ans