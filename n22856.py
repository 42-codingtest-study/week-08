# 넘어려움

import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

n = int(input())
tree = {}

for _ in range(n):
    a, b, c = map(int, input().split())
    tree[a] = [b, c]

visited1 = [0] * (n + 1)
count1 = 0
# 모든 노드들을 이동하며 거리 구하기
def dfs1(node):
    global count1
    visited1[node] = 1

    if not visited1[tree[node][0]] and tree[node][0] != -1:
        dfs1(tree[node][0])
        count1 += 1

    if not visited1[tree[node][1]] and tree[node][1] != -1:
        dfs1(tree[node][1])
        count1 += 1

visited2 = [0] * (n + 1)
count2 = 0
# 오른쪽으로 이동하기
def dfs2(node):
    global count2
    visited2[node] = 1

    if not visited2[tree[node][1]] and tree[node][1] != -1:
        dfs2(tree[node][1])
        count2 += 1

dfs1(1)
dfs2(1)

print(2 * count1 - count2)