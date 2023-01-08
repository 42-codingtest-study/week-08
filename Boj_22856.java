import java.util.*;

public class Boj_22856 {

    static List<List<Integer>> table = new ArrayList<>();
    static ArrayList<Integer> inorderResult = new ArrayList<>();
    static int[] visited = new int[200002];
    public static void main(String[] args) {

        int n;
        int a,b;
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++) {
            table.add(new ArrayList<>());   //1) 각 리스트 초기화
        }

        for (int i = 0; i < n; i++) {       //2) 입력받기
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            int curNode = Integer.parseInt(st.nextToken());
            int lChild = Integer.parseInt(st.nextToken());
            int rChild = Integer.parseInt(st.nextToken());
            table.get(curNode).add(lChild);
            table.get(curNode).add(rChild);
        }
        inorder(1);        //3) 중위 순회. 중위순회 과정이 inorderResult에 저장됩니다.
        int inorderLastVisit = inorderResult.get(inorderResult.size()-1);       //4) 중위 순회의 마지막 방문 값

        //이제 dfs 를 통해 루트 노드에서 중위순회 마지막 값 까지의 경로 길이를 구한다.
        int totalVisits = doDFS(1, inorderLastVisit, n);

        int toLastVisit = 0;

        int currentNode= 1;         // 1부터 시작해서 오른쪽 가장 아래 노드까지 향하는 거리를 계산합니당.
        while (true) {
            int next = table.get(currentNode).get(1);
            if (next != -1) {
                currentNode = next;
                toLastVisit++;
            }
            else break;
        }

        System.out.println(totalVisits*2 - toLastVisit);
        //가장 마지막 노드 까지 dfs로 이동한 길이의 2배에서  루트노드에서 맨 마지막 노드이면서 오른쪽에 있는 노드일 경우까지 이동한 경우만큼 빼주면 된다...
        //다시 돌아오는 과정이 없으니까!!
    }

    public static void inorder(int cur) {
        if (cur == -1) {
            return;
        }
        inorder(table.get(cur).get(0));
        inorderResult.add(cur);
        inorder(table.get(cur).get(1));
    }

    public static int doDFS(int from, int to, int n) {
        Queue<Integer> q = new LinkedList<>();

        q.add(from);
        visited[from] = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.peek(); q.remove();

            for (int i = 0; i < 2; i++) {
                if (table.get(cur).get(i) != -1 && visited[table.get(cur).get(i)] == 0) {
                    q.add(table.get(cur).get(i));
                    cnt++;
                    visited[table.get(cur).get(i)] = visited[cur]++;
                }
            }
        }

        return cnt;
    }
}


//이게 도와줌. https://viyoung.tistory.com/346