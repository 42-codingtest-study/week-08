import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
tree = { arr[0] : -1 }

for i in range(1, n):
    temp = arr[i]
    if temp not in tree:
        tree[temp] = arr[i - 1]

print(len(tree))
for i in range(len(tree)):
    print(tree[i], end = " ")