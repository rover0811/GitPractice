N,M=map(int,input().split())

graph=[]
for i in range(N):                      #그래프에 값 넣기
    graph.append(list(map(int,input())))

#일단 그래프를 써야함은 인식했음
#그렇다면 dfs를 써야하는가? bfs를 써야하는가? 연결되어있으면 거기로 가야하므로 dfs해야함

#그렇다면 어떻게 코드를 짜야하는가
#미로 찾기 느낌? -> 근데 그건 스택이었지 않나-> dfs도 스택이잖아
#그리고 재귀적 접근법이었음 
#상하좌우를 보게 시킨다-> 접근했는지 안했는지 알려줄 그것도 필요하지 않으려나 그럼

def dfs(x,y):
    if x<= -1 or x>= N or y<= -1 or y>= M: #범위를 벗어남
        return False
    if graph[x][y]==0:                     #아직 방문 하지 않았음
        graph[x][y]=1 #해당 노드 방문처리
        dfs(x-1,y)    #상
        dfs(x,y-1)    #하
        dfs(x+1,y)
        dfs(x,y+1)    #우
        return True
    return False

result=0
for i in range(N):    #여기서 왜 N번 반복하는가? 깊이만큼 하는 거임
    for j in range(M):#여기서 왜 M번 반복하는가? 너비만큼 하는 거임
        if dfs(i,j)==True:
            result+=1

print(result)

