#트리의 부모는?
import sys
input = sys.stdin.readline
#재귀 허용 깊이를 수동으로 늘려주는 코드
sys.setrecursionlimit(10 ** 9)

N = int(input())
tree = [[] for _ in range (N + 1)]
anwser = [0] * (N + 1)

for _ in range (N - 1) :
	a, b = map(int, input().split())
	tree[a].append(b)
	tree[b].append(a)

def dfs(start, tree, anwser):
	for i in tree[start] :
		if anwser[i] == 0 :
			anwser[i] = start
			dfs(i, tree, anwser)

dfs(1, tree, anwser)

for i in range(2, N + 1):
	print(anwser[i])