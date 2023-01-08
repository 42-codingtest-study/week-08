import java.util.*;

public class Boj_15805 {

    public static void main(String[] args) {
        int n;
        int[] table = new int[200002];
        int[] visited = new int[200002];
        int[] parents = new int[200002];
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        String tmp = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(tmp);
        for (int i = 0; i < n; i++) {
            table[i] = Integer.parseInt(st.nextToken()) + 1;
        }

        visited[table[0]] = -1;
        parents[table[0]] = 0;

        int max_val = -1;

        for (int i = 1; i < n; i++) {
            if (visited[table[i]] != 0) {       //이미 위에서 방문한거 -> 말단 노드까지 갔다가 돌아오는 중,  그냥 continue
                continue;
            }
            if (visited[table[i]] == 0) {       // 지금 순회하며 첫방문, 윗 노드가 부모 노드임을 저장하고 방문 표시 해주면 됨.
                visited[table[i]] = 1;
                parents[table[i]] = table[i-1];
                max_val = Math.max(max_val, table[i]); //도시가 몇개 있는지 알려면 가장 큰 도시번호가 뭔지 알면 되니까!
            }
        }

        max_val = Math.max(max_val, table[0]);  // 첫번째 시작 도시가 제일 클 수도 있기 때문에.
        System.out.println(max_val);
        for (int i = 1; i <= max_val; i++) {
            System.out.print(parents[i]-1+ " ");
        }
    }

}
