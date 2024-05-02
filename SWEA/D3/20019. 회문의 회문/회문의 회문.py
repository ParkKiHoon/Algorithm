times = int(input())
for time in range(times):
    def isPalindrome(arr):
        middle=int(len(arr)/2)
        for i in range(middle):
            if arr[i]!=arr[-(i+1)]:
                return 0
        return 1
    arr = input()
    middle=int((len(arr)-1)/2)
    a1,a2,a3=isPalindrome(arr[:middle]),isPalindrome(arr),isPalindrome(arr[middle+1:])

    print("#",time+1," ","YES" if all([a1,a2,a3]) else "NO",sep="")