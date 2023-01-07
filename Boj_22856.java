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
        inorder(1);        //3) 중위 순회
        int inorderLastVisit = inorderResult.get(inorderResult.size()-1);       //4) 중위 순회의 마지막 방문 값

        //이제 dfs 를 통해 루트 노드에서 중위순회 마지막 값 까지의 경로 길이를 구한다.
        int totalVisits = doDFS(1, inorderLastVisit, n);

        //방법1.
        //int toLastVisit = visited[inorderLastVisit];      //가장 마지막 방문 노드가 뭔지 저장한다.

        //방법2.
        int toLastVisit = 0;
        int currentNode= 1;
        while (true) {
            int next = table.get(currentNode).get(1);
            if (next != -1) {
                currentNode = next;
                toLastVisit++;
            }
            else break;
        }
        //방법1이 틀리고 방법2가 된 이유는, 총 간선의 길이 2배에서 제외해 주어야 하는 값이 "루트에서 가장 마지막 중위순회 방문 노드 까지의 길이" 가 아니라
        // "루트에서 오른쪽으로 가장 멀리 떨어져 있는 노드 까지의 길이" 이기 때문이다.
        // 반례로는 1번 노드에 2번 노드가 왼쪽 자식으로 달려있는 경우가 있겠다.
            // 이 케이스에서 내 방법1의 경우에는 값이 1이 나오는데, 간선의 길이(1) * 2 - 1 (가장 마지막 방문 노드(2) 까지의 길이) 이기 때문이다.
            // 근데 이 경우는 1 -> 2 -> 1 로 방문을 하고 종료이기 때문에 답이 2가 나와야 하는것임.
        System.out.println(totalVisits*2 - toLastVisit);
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


//보고했어염 https://viyoung.tistory.com/346