def solution(survey, choices):
    ans={'R':0,'T':0,'C':0,'F':0,'J':0,'M':0,'A':0,'N':0}
    for i in range(len(survey)):
        ind=choices[i]
        if ind<4:
            ans[survey[i][0]]+=(4-ind)
        elif ind>4:
            ans[survey[i][1]]+=(ind-4)
    sol=''
    tmp=list(ans.items())
    for i in range(0,8,2):
        if tmp[i][1]<tmp[i+1][1]: sol+=tmp[i+1][0]
        else: sol+=tmp[i][0]
    return sol