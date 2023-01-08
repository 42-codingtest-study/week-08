a, b = map(int, input().split())

left = 0
right = 0

while a > 0 and b > 0:
    if a > b:
        left += a // b
        a %= b
    else:
        right += b // a
        b %= a

left += a - 1
right += b - 1

print(left, right)