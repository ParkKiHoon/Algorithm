def solution(p):
    
    def reverse(str):
        tmp=""
        for i in str:
            if i=="(":
                tmp+=")"
            else:
                tmp+="("
        return tmp
    
    def step(str):
        if str == "":
            return ""
        
        u=""
        v=""
        left=0
        right=0
        tmp=""
        for i in range(len(str)):
            tmp+=str[i]
            if str[i]=="(":
                left+=1
            else:
                right+=1
            if left>0 and left==right:
                u=tmp
                v=str[i+1:]
                break
        stk=[]
        for i in u:
            stk.append(i)
            while len(stk)>1 and stk[-1]==")" and stk[-2]=="(":
                stk.pop()
                stk.pop()
        if len(stk)==0:
            u+=step(v)
        else:
            u="(" + step(v) + ")" + reverse(u[1:-1])
        return u
        
    return step(p)