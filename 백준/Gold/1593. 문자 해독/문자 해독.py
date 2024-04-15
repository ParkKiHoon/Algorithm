a,b=map(int,input().split())
str1=input()
str2=input()
answer = 0
wa = [0] * 52
sa = [0] * 52

for i in range(a):
    if 'a'<= str1[i] <='z':
        wa[ord(str1[i])-ord('a')]+=1
    else:
        wa[ord(str1[i]) - ord('A')+26] += 1

start,length,cnt=0,0,0

for i in range(b):
    if 'a'<=str2[i]<='z':
        sa[ord(str2[i]) - ord('a')] += 1
    else:
        sa[ord(str2[i]) - ord('A')+26] += 1
    length+=1

    if length==a:
        if wa==sa:
            cnt+=1
        if 'a'<=str2[start]<='z':
            sa[ord(str2[start])-ord('a')]-=1
        else:
            sa[ord(str2[start]) - ord('A')+26] -= 1
        start+=1
        length-=1
print(cnt)