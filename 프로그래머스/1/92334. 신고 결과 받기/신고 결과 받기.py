def solution(id_list, report, k):
    report=list(set(report))
    dict1={}
    dict2={}
    for id in id_list:
        dict1[id]=0
        dict2[id]=[]
    for re in report:
        a,b = re.split()
        tmp=dict2[b]
        tmp.append(a)
        dict2[b]=tmp
    
    for i in dict2:
        if len(dict2[i])>=k:
            for j in dict2[i]:
                dict1[j]+=1

    ans=[]
    for i in dict1.items():
        ans.append(i[1])
    return ans