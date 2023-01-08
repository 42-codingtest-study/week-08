#무한이진트리
import sys
input = sys.stdin.readline

A, B = map(int, input().split())
L, R = 0, 0

while A > 1 and B > 1:
	# 더 크면 그 쪽으로 이동한 경우
	if A > B :
		L += (A // B)
		A %= B
	else :
		R += (B // A)
		B %= A

L += A - 1
R += B - 1

print(L, R)