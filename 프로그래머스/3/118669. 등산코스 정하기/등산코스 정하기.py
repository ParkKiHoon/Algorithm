import heapq
def solution(n, paths, gates, summits):
    conn=[[]for _ in range(n+1)]
    for i,j,w in paths:
        conn[i].append((j,w))
        conn[j].append((i,w))
        
    pq = [(0,gate) for gate in gates]
    MAX=10000001
    dis=[MAX for _ in range(n+1)]
    
    while pq:
        intensity,node=heapq.heappop(pq)
        if dis[node] <= intensity:
            continue
        dis[node] = intensity
        if node in summits:
            continue
        for nxt,nxt_w in conn[node]:
            nxt_w=max(intensity,nxt_w)
            if dis[nxt]<=nxt_w:
                continue
            heapq.heappush(pq,(nxt_w,nxt))
            
    answer = [0,MAX]    
    for summit in summits:
        if dis[summit] < answer[1]:
            answer[0],answer[1]=summit,dis[summit]
        elif dis[summit]==answer[1] and summit <answer[0]:
            answer[0]=summit

    return answer