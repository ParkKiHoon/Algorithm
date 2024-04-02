import copy
from collections import deque

n, m, k = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
board = [[5 for _ in range(n)] for _ in range(n)]
trees = [[deque() for _ in range(n)] for _ in range(n)]
dead_trees = [[list() for _ in range(n)] for _ in range(n)]
for _ in range(m):
    x,y,z = map(int,input().split(' '))
    trees[x-1][y-1].append(z)

for times in range(k):
    for i in range(n):
        for j in range(n):
            len_tree = len(trees[i][j])
            for k in range(len_tree):
                if trees[i][j][k]>board[i][j]:
                    for _ in range(k,len_tree):
                        dead_trees[i][j].append(trees[i][j].pop())
                    break
                else:
                    board[i][j] -= trees[i][j][k]
                    trees[i][j][k]+=1

    for i in range(n):
        for j in range(n):
            while dead_trees[i][j]:
                board[i][j]+=dead_trees[i][j].pop()//2

    for i in range(n):
        for j in range(n):
            for k in range(len(trees[i][j])):
                if trees[i][j][k]%5==0:
                    for t1 in range(-1,2,1):
                        for t2 in range(-1,2,1):
                            if t1==0 and t2==0:
                                continue
                            else:
                                if 0<=i+t1<n and 0<=j+t2<n:
                                    trees[i+t1][j+t2].appendleft(1)
            board[i][j]+=arr[i][j]

ans=0
for i in range(n):
    for j in range(n):
        ans+=len(trees[i][j])
print(ans)