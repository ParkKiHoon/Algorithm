T = 10
for tc in range(1, T+1):
    # palindrome 의 길이 입력
    p = int(input())
    # 평면 글자판은 8x8
    N = 8
    # 글자판 입력
    arr = [list(input()) for _ in range(N)]

    cnt = 0
    for i in range(N):
        for j in range(N-p+1):
            if arr[i][j:j+p]==arr[i][j:j+p][::-1]:
                cnt+=1


    for i in range(N):
        for j in range(N-p+1):
            char=''
            for k in range(j,j+p):
                char+=arr[k][i]
            if char==char[::-1]:
                cnt+=1

    # 결과 출력
    print('#{} {}'.format(tc, cnt))