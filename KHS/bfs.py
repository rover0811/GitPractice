# BFS는 너비 우선탐색
# 1. 탐색 시작 노드를 큐에 삽입하고 방문처리를 한다 -> 인자값은 2개
# 2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문처리
# 3. 2번의 과정을 계속 수행

from collections import deque

def bfs(graph,start,visited):        #너는 왜 인자가 3개일까?-> 함수는 그래프, 첫 시작, 그리고 방문 배열이 필요하다
    queue=deque([start])             #큐에 첫번째 정점 넣어주기
    visited[start]=True              #넌 뭘까? 시작했으니 거긴 방문이야
    while queue:                     #이제 시작하기 지금 큐에 하나 들어가있으니 실행됨
        v=queue.popleft()            #빼고 출력
        print(v,end=' ')             #왜 이렇게 할까? 파이썬의 기본은 end='\n'임
        for i in graph[v]:           #그래프의 시작 배열로 들어간다. 즉 i에는 2, 3, 8이 들어갈 예정
            if not visited[i]:       
                queue.append(i)
                visited[i]=True

graph=[
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]
visited=[False]*9

bfs(graph,1,visited)

