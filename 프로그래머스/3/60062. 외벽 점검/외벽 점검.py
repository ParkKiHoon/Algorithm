import itertools
def solution(n, weak, dist):
    answer = 0
    wl=len(weak)
    minc=100000000000
    weak=weak+[w+n for w in weak]

    for start in range(wl):
        for j in itertools.permutations(dist,len(dist)):
            cnt=1
            pos=start
            for i in range(1,wl):
                nextpos=start+i
                diff = weak[nextpos]-weak[pos]
                if diff > j[cnt-1]:
                    cnt+=1
                    pos=nextpos
                if cnt>len(dist):
                    break
            if cnt<=len(dist):
                minc=min(minc,cnt)
    
    if minc==100000000000:
        minc=-1
    return minc