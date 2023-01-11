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

map<int, ii> relation;

int n, a = -1 ,r = -1;

void travel(int cur, bool flag){
	if (cur == -1) 
		return;
	
	a++, travel(relation[cur].first, 0);

	if (flag)
		r++, travel(relation[cur].second, 1);
	else
		travel(relation[cur].second, 0);
}

int main()
{
	ios_base::sync_with_stdio(false); 
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	for (int i = 0, a, b, c; i < N; i++){
		cin >> a >> b >> c;
		relation[a].first = b;
		relation[a].second = c;
	}

	travel(1, 1);
	cout << 2*a - r;
	return (0);
}
