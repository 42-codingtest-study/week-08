import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for i in range(n+1)]
temp = []

for i in range(n-1):
    a, b, r = map(int, input().split())
    # print(graph)
    graph[a].append((b, r))
    graph[b].append((a, r))

for i in range(m):
    temp.append(set(map(int, input().split())))


def bfs(start, to):
    queue = deque()
    visited = [False] * (n+1)
    visited[start] = True
    d = 0
    queue.append((start, 0))

    while queue:
        v, d = queue.popleft()
        if v == to:
            return d

        for i, j in graph[v]:
            if not visited[i] :
                visited[i] = True
                queue.append((i, j+d))

for i, j in temp:
    print(bfs(i, j))