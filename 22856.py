# 트리 순회
# https://www.acmicpc.net/problem/22856

import sys
input = sys.stdin.readline
N = int(input())
tree = [[] for _ in range(N + 1)]
cnt = 0
for _ in range(N - 1) :
    a, b, c = map(int, input().split())
    tree[a].append(b)
    tree[a].append(c)
    
    if b != -1 :
        cnt += 1
    if c != -1 :
        cnt += 1

visited = [0] * (N + 1)
visited[0] = 1

def move(curr, m) :
    if visited[curr] == 