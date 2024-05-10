import copy

times = 10
for time in range(times):
    notUse=input()
    list=""
    stk=[]
    for i in input():
        if i.isdecimal():
            list+=i
        else:
            if i=="(":
                stk.append("(")
            elif i==")":
                while stk and stk[-1]!="(":
                    list+=stk.pop()
                stk.pop()
            elif i=="*":
                stk.append("*")
            else:
                while stk:
                    if stk[-1]=="*" or stk[-1]=="+":
                        list+=stk.pop()
                    else:
                        break
                stk.append("+")
    while stk:
        list+=stk.pop()

    stk2=[]
    for i in list:
        if i.isdecimal():
            stk2.append(i)
        elif i=="*":
            a=int(stk2.pop())
            b=int(stk2.pop())
            stk2.append(a*b)
        else:
            a=int(stk2.pop())
            b=int(stk2.pop())
            stk2.append(a+b)
    print("#{} {}".format(time+1,stk2[-1]))
