import copy

times = 10
for time in range(times):
    notUse=input()
    list=input()
    stk=[]
    for i in list:
        stk.append(i)
        while True:
            if len(stk)>1:
                if [stk[-2],stk[-1]]==["(",")"] or [stk[-2], stk[-1]] == ["[", "]"] or [stk[-2], stk[-1]] == ["{", "}"] or [stk[-2], stk[-1]] == ["<", ">"]:
                    stk.pop()
                    stk.pop()
                else:
                    break
            else:
                break
    print("#{} {}".format(time+1,1 if len(stk)==0 else 0))
