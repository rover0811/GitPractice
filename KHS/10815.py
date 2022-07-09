# import sys
# N=int(input())
# beforelist = list(map(int, sys.stdin.readline().split()))
# M=int(input())
# afterlist = list(map(int, sys.stdin.readline().split()))
# beforelist.sort()

# def binarySearch(after,number):
#     first=0
#     last=number-1
#     while(first<=last):
#         mid=(first+last)//2
#         if after==beforelist[mid]:
#             return 1
#         elif after> beforelist[mid]:
#             first=mid+1
#         elif after< beforelist[mid]:                
#             last=mid-1
#     return 0

# for j in afterlist:
#     print(binarySearch(j,N))

import sys
N=int(input())
beforelist = list(map(int, sys.stdin.readline().split()))
M=int(input())
afterlist = list(map(int, sys.stdin.readline().split()))
beforelist.sort()

def binarySearch(after,number):
    first=0
    last=number-1
    while(first<=last):
        mid=(first+last)//2
        if after==beforelist[mid]:
            return 1
        elif after> beforelist[mid]:
            first=mid+1
        elif after< beforelist[mid]:                
            last=mid-1
    return 0

for j in afterlist:
    if(binarySearch(j,N)):
        
        
            
                




