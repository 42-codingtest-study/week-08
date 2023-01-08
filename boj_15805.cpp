#include <iostream>
#include <algorithm>
#include <utility>
#include <vector>
#include <string>
#include <stack>
#include <queue>
#include <deque>
#include <list>
#include <map>
#include <set>
#include <cstring> //memeset

using namespace std;

#define ffor(i, x) for (int (i) = 0; (i) < (x) ; (i)++) // ⭐️ 0부터 x까지 for-loop
#define fffor(i, x) for (int (i) = 1; (i) <= (x) ; ++(i)) // ⭐️ 1부터 x까지 for-loop
#define cc(x) cin >> (x); // ⭐️ stdin 인풋 하나 받기
#define ccc(x) int (x); cin >> (x); // ⭐️ int 변수 만들고 그걸로 stdin 인풋 하나 받기
#define coo(x) cout << x << '\n'; // ⭐️ 변수 출력하고 줄바꿈
#define cob(x) cout << x << ' '; // ⭐️ 변수 출력하고 스페이스바
#define ii pair<int, int> // ⭐️ 보통 vector랑 많이 쓴다
#define ll long long // ⭐️ 매번 long long 치고 있으면 현기증이 옴

int dx[] = {1, 0, -1, 0}; // 동 남 서 북 // ⭐️ DFS, BFS 문제 풀 때 꼭 씀
int dy[] = {0, 1, 0, -1}; // ⭐️ 이렇게 안하고 2x4 배열로 만들어 쓰는 사람들도 있는 것 같다
int INF = 1e9 + 7; // ⭐️ 의외로 자주 쓰는 수. 자주 쓰고 말고는 문제를 풀면서 생각해보면 될 문제

int vertex[200001];
int parent[200001];
set<int> s;

int main()
{
	ios_base::sync_with_stdio(false); 
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> vertex[i];
	
	// 0의 부모는 -1;
	parent[vertex[0]] = -1;
	s.insert(vertex[0]);

	for (int i = 1; i < N; i++){
		// 방문한 정점이면 건너뛴다.
		if (s.count(vertex[i])) continue;
		// 새로운 정점이라면 이전 정점이 부모다.
		// 부모에서 자식으로 가기 때문
		parent[vertex[i]] = vertex[i - 1];
		s.insert(vertex[i]);
	}

	cout << s.size() << '\n';
	for (int i = 0; i < s.size(); i++)
		cout << parent[i] << " ";
	return (0);
}
