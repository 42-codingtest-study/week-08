# 전단지 돌리기
# https://www.acmicpc.net/problem/19542

import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline
N, S, D = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)
answer = 0

for _ in range(N - 1) :
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)
    
def dfs(curr, prev) :
    global answer
    max_d = 0
    for next in graph[curr] :
        if next != prev :
            max_d = max(max_d, dfs(next, curr))	# 여기서 재귀가 반복되면서 이동 거리가 결정된다
    if max_d >= D :
        answer += 1
    return max_d + 1
            
dfs(S, 0)
print((answer - 1) * 2 if answer else 0)