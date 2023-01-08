#윤호는 관광 가이드
import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
arr = [0] * 200000
parent = [0] * 200000
visit = [False] * 200000

inp = list(map(int, input().split()))

for i in range (1, n + 1):
	arr[i] = inp[i - 1]

answer = 0
city = 0

for i in range (1, n + 1):
	if not visit[arr[i]] :
		answer += 1
		visit[arr[i]] = True
		city = arr[i]
	else :
		parent[city] = arr[i]
		city = arr[i]

parent[city] = -1

print(answer)
for i in range (answer) :
	print(parent[i], end = ' ')