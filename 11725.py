import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())
graph = [[] for _ in range(N + 1)]
answer = [0] * (N + 1)
visited = [0] * (N + 1)
def dfs(node):
    visited[node] = True
    for x in graph[node]:
        if not visited[x]:
            dfs(x)
            answer[x] = node

for _ in range(N - 1):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

dfs(1)
for j in answer[2:]:
    print(j)
