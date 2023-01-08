
import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n = int(input())

graph = [[] for _ in range(n + 1)]
parents = [0 for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(start):
    for i in graph[start]:
        if parents[i] == 0:
            parents[i] == start
            dfs(i)

dfs(1)

for i in range(2, n + 1):
    print(parents[i])

