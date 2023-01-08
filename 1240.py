# 노드사이의 거리
# https://www.acmicpc.net/problem/1240

import sys
from collections import deque
sys.setrecursionlimit(10 ** 7)
N, M = map(int, input().split())
tree = [[] for _ in range(N + 1)]
for _ in range(N - 1) :
    a, b, c = map(int, input().split())
    tree[a].append([b, c])
    tree[b].append([a, c])

def find(goal, q) :	# bfs
    while q :
        next, dist = q.popleft()
        if next == goal :
            return dist
        
        for i, j in tree[next] :
            if visited[i] == 0 :
                visited[i] = 1
                q.append([i, dist + j])

    
for _ in range(M) :
    start, end = map(int, input().split())
    visited = [0] * (N + 1)
    dq = deque(tree[start])	# 초기값 설정
    print(find(end, dq))
    