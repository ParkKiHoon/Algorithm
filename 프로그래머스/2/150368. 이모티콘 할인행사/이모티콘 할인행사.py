ans=[0,0]
def solution(users, emoticons):
    emoticons=list(map(str,emoticons))
    def test(emoticons):
        global ans
        memberCnt=0
        totalSum=0
        for user in users:
            tempSum=0
            for emoticon in emoticons:
                price,per=map(int,emoticon.split(","))
                if per>=user[0]:
                    tempSum+=int(price*(100-per)/100)
                if tempSum>=user[1]:
                    break
            if tempSum>=user[1]:
                memberCnt+=1
            else:
                totalSum+=tempSum
        if memberCnt==ans[0]:
            if totalSum>ans[1]:
                ans=[memberCnt,totalSum]
        elif memberCnt>ans[0]:
            ans=[memberCnt,totalSum]

    def dfs(emoticons,cnt):
        if cnt==len(emoticons):
            test(emoticons)
            return
        for i in([10,20,30,40]):
            emoticons[cnt]=emoticons[cnt]+","+str(i)
            dfs(emoticons,cnt+1)
            emoticons[cnt]=emoticons[cnt].split(",")[0]
    dfs(emoticons,0)
    return ans