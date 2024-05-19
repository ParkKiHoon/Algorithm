T = int(input())
for tc in range(1, T+1):
    # palindrome 의 길이 입력
    p = input()
    p="0"+p
    cnt=0
    for i in range(len(p)):
        if i>0:
            if p[i]!=p[i-1]:
                cnt+=1
    print('#{} {}'.format(tc, cnt))