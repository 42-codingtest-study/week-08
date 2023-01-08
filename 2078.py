# 무한이진트리
# https://www.acmicpc.net/problem/2078

A, B = map(int, input().split())
left, right = 0, 0
while A > 1 and B > 1 :		# 이 조건으로 루트까지 갈 수 있다.
    if A > B :				# A가 B보다 더 크다면 부모 노드 기준 왼쪽에 있는것임
        left += A // B		# 왼쪽 노드는 (a+b, b)이므로 b로 나누어 어느정도 왼쪽에 있는지 알 수 있다
        A %= B				# 이전 노드로 돌아가기
    else :
        right += B // A
        B %= A
left += A - 1
right += B - 1
print(left, right)