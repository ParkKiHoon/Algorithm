from bisect import bisect_right
def solution(dice):
    from itertools import combinations
    N=len(dice)
    for i in dice:
        i.sort()
    NList=[i for i in range(N)]
    CombList=list(combinations(NList,N//2))
    ans=[0] * (N//2)
    max_ans=0
    for i in CombList:
        not_i=[]
        for j in NList:
            if j not in i:
                not_i.append(j)
        
        draw_List=[[],[]]
        
        def dfs(val,a,depth,arr,list_num):
            if depth==len(val):
                tmp=0
                for i, d in enumerate(a):
                    tmp+=dice[arr[i]][d]
                draw_List[list_num].append(tmp)
                return
            for i in range(val[depth]):
                a[depth]=i
                dfs(val,a,depth+1,arr,list_num)

        def multi_for(val,arr,list_num):
            a=[0]*len(val)
            dfs(val,a,0,arr,list_num)
            
        multi_for([6]*(N//2),i,0)
        multi_for([6]*(N//2),not_i,1)
        win=0
        draw_List[0].sort()
        draw_List[1].sort()
        for k2 in range(len(draw_List[1])):
            left_index=bisect_right(draw_List[0],draw_List[1][k2])
            win+=len(draw_List[0])-left_index

        if win>max_ans:
            max_ans=win
            ans=i
    sol=[]
    for i in ans:
        sol.append(i+1)
    sol.sort()
    #(~˘▾˘)~
    return sol