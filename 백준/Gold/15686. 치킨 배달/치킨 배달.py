import itertools
n,m= map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
shop=[]
home=[]
minval=[2147483647]
for i in range(n):
    for j in range(n):
        if board[i][j]==2:
            shop.append((i,j))
        elif board[i][j]==1:
            home.append((i,j))
from itertools import combinations

def get_dist(arr):
    total=0
    for i in home:
        tmp=2147483647
        for j in arr:
            tmp=min(tmp,abs(i[0]-j[0]) + abs(i[1]-j[1]))
        total+=tmp
    minval[0]=min(total,minval[0])


order = list(itertools.combinations(shop,m))
for i in order:
    get_dist(i)

print(minval[0])