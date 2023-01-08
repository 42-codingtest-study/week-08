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


int n;
vector<int> adj[100001];
int p[100001];

void dfs(int cur){
	for (int next: adj[cur]){
		// cur의 인접 정점들이 cur의 부모가 되지 않도록 방지
		if (p[cur] == next) continue;
		// cur가 cur의 인접 정점들의 부모가 됨
		p[next] = cur;
		// 인접 정점들이 다시 cur가 되어 자식들 찾기
		dfs(next);
	}
}

int main()
{
	ios_base::sync_with_stdio(false); 
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for(int i = 0; i < n - 1; i++){
		// 인접 행렬 생성 
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	// 부모 값 갱신
	dfs(1);
	for(int i = 2; i <= n; i++){
		cout << p[i] << '\n';
	}
	return (0);
}
