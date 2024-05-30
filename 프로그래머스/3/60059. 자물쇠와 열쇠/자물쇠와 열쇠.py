def rotate(arr):
    L=len(arr)
    ret=[[0]*L for _ in range(L)]
    for i in range(L):
        for j in range(L):
            ret[j][L-1-i]=arr[i][j]
    return ret

def check(arr):
    L=len(arr)//3
    for i in range(L,L*2):
        for j in range(L,L*2):
            if arr[i][j] != 1:
                return 0
    return 1
    
def solution(key, lock):
    L=len(key)
    M=len(lock)
    board=[[0]*(M*3) for _ in range(M*3)]
    for i in range(M):
        for j in range(M):
            board[i+M][j+M]=lock[i][j]
            
    for rot in range(4):
        for i in range(0,M*2+1):
            for j in range(0,M*2+1):
                for k1 in range(L):
                    for k2 in range(L):
                        board[i+k1][j+k2]+=key[k1][k2]
                if check(board):
                    return True
                for k1 in range(L):
                    for k2 in range(L):
                        board[i+k1][j+k2]-=key[k1][k2]  
        key=rotate(key)
            
                
    return False