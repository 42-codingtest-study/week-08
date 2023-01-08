# 트리 나라 관광 가이드
# https://www.acmicpc.net/problem/15805

K = int(input())
map_lst = list(map(int, input().split()))
tree = set()
visited = [0] * (K)
visited[0] = -1
tree.add(map_lst[0])
for i in range(len(map_lst)) :
    if map_lst[i] not in tree :
        visited[map_lst[i]] = map_lst[i - 1]
        tree.add(map_lst[i])
        
print(len(tree))
print(*(visited[:len(tree)]))