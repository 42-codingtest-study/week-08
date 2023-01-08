#트리 순회
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

N = int(input())
node_tree = {}
parent = [0] * (N + 1)
movement = 0

#class 생성
class Node :
	def __init__(self, data, left, right):
		self.data = data
		self.left = left
		self.right = right
#node트리 만들어주기
for _ in range(N) :
    a, b, c = map(int, input().split())
    node_tree[a] = Node(a, b, c)
#부모노드 누군지 저장
def fill_parents(node) :
    if node.left != -1 :
        fill_parents(node_tree[node.left])
    parent.append(node.data)
    if node.right != -1 :
        fill_parents(node_tree[node.right])

#몇번 움직이는지 카운트
def move_count(node) :
    global movement

    if node.left != -1 :
        move_count(node_tree[node.left])
        movement += 1

    if node.data == parent[-1] :
        print(movement)
        return
	#왼쪽 다 가면 올라와야하니까
    movement += 1
	
    if node.right != -1:
        move_count(node_tree[node.right])
        movement += 1

fill_parents(node_tree[1])
move_count(node_tree[1])