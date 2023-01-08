#노드사이의 거리
import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b, dis = map(int,input().split())
    graph[a].append((b, dis))
    graph[b].append((a, dis))

def bfs(start, find):
	q = deque()
	q.append((start))
	visited = [-1] * (n + 1)
	visited[start] = 0
	while q:
		v = q.popleft()
		
		if v == find:
			break
		#노드번호, 간선길이	
		for i, dis in graph[v]:
			if visited[i] == -1:
				visited[i] = visited[v] + dis
				q.append((i))
	return visited[find]

for _ in range(m):
    a, b = map(int, input().split())
    print(bfs(a, b))