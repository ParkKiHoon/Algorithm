def solution(bandage, health, attacks):
    final_time=attacks[-1][0]
    cnt=0
    origin_hp=health
    for i in range(1,final_time+1):
        print(health)
        if attacks[0][0]!=i:
            print("S")
            cnt+=1
            health+=bandage[1]
            if cnt==bandage[0]:
                health+=bandage[2]
                cnt=0
            if health>origin_hp:
                health=origin_hp
        else:
            print("A")
            att=attacks.pop(0)
            health-=att[1]
            cnt=0
            if health<=0:
                return -1
            
    answer = 0
    return health