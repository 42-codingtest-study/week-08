# 트리의 부모 찾기
# https://www.acmicpc.net/problem/11725

import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline
N = int(input())
tree = [[] for _ in range(N + 1)]
parents = [0] * (N + 1)
for _ in range(N - 1) :
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

def find_parent(curr, tree, parents) :	# dfs인데 방문 안한곳에 현재 노드의 값을 넣어준다
    for next in tree[curr] :
        if parents[next] == 0 :
            parents[next] = curr
            find_parent(next, tree, parents)

find_parent(1, tree, parents)

for i in range(2, len(tree)) :
    print(parents[i])