# 넘어려움

n = int(input())

city = list(map(int, input().split()))

k = max(city) + 1
parents = [0] * k
visited = [0] * k

for i in range(1, n):
    if visited[city[i]] == 0:
        parents[city[i]] = city[i - 1]
        visited[city[i]] = 1

parents[city[0]] = -1

print(k)
print(*parents)