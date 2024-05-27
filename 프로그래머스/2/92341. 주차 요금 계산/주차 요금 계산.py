def solution(fees, records):
    dic={}
    records.sort(key=lambda x:int(x.split(" ")[1]))
    for record in records:
        time,num,type=record.split()
        num=int(num)
        h,m=time.split(":")
        time=60*int(h)+int(m)
        try:
            a,b,c=dic[num]
            if a==0:
                dic[num]=[1,b+time-c,0]
            else:
                dic[num]=[0,b,time]
        except:
            dic[num]=[0,0,time]
    import math
    sol=[]

    for i in dic:
        a,b,c=dic[i]
        print(i,a,b,c)
        if a==0:
            total=b+(1439-c)
            if total>fees[0]:
                fee=fees[1]+ math.ceil((total-fees[0])/fees[2]) * fees[3]
                sol.append(fee)
            else:
                sol.append(fees[1])
        else:
            total=b
            if total>fees[0]:
                fee=fees[1]+ math.ceil((total-fees[0])/fees[2]) * fees[3]
                sol.append(fee)
            else:
                sol.append(fees[1])
    return sol