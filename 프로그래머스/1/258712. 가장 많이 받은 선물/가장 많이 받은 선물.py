def solution(friends, gifts):
    friend_dict={}
    friend_dict2={}
    friend_dict3={}
    for i in friends:
        friend_dict[i]=0
        friend_dict3[i]=0
    for i in friends:
        for j in friends:
            if i!=j:
                friend_dict2[i+","+j]=0
    for i in gifts:
        a,b=i.split()
        friend_dict[a]+=1
        friend_dict[b]-=1
        friend_dict2[a+","+b]+=1
    for i in friends:
        for j in friends:
            if i!=j:
                if friend_dict2[i+","+j]>friend_dict2[j+","+i]:
                    friend_dict3[i]+=1
                elif friend_dict2[i+","+j]<friend_dict2[j+","+i]:
                    friend_dict3[j]+=1
                else:
                    if friend_dict[i]>friend_dict[j]:
                        friend_dict3[i]+=1
                    elif friend_dict[i]<friend_dict[j]:
                        friend_dict3[j]+=1
    maxval=0
    for i in friend_dict3:
        maxval=max(maxval,friend_dict3[i])
    return maxval//2