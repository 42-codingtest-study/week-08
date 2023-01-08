n, m = map(int, input().split())

graph = graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

answer = 0

def dfs(start, end, distance):
    visited[start] = 1

    for i in range(1, n + 1):
        distance = graph[start][i]

        if graph[start][i] > 0 and not visited[i]:
            if i == end:
                answer = distance + graph[start][i]
            else:
                dfs(i, end, distance + graph[start][i])

for _ in range(n - 1):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c

for _ in range(m):
    a, b = map(int, input().split())
    dfs(a, b, 0)
    print(answer)

