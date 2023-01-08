import sys
input = sys.stdin.readline

a, b = map(int, input().split())
left = 0
right = 0

while True:
    if a < b:
        b -= a
        right += 1
    elif a > b:
        a -= b
        left += 1
    if a == 1 and b == 1:
        break

print(f'{left} {right}')