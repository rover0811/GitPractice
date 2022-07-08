scale=[i for i in range(1,9)]
inputscale=list(map(int,input().split()))
if scale==inputscale:
    print("ascending")
elif scale==sorted(inputscale,reverse=True):
    print("descending")
else:
    print("mix")
