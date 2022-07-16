#이항계수1
N, R=map(int,input().split())
result=1
for i in range(N,N-R,-1):
    result*=i
print(result/R)