import java.util.*;

public class Boj_1240 {

    public static void main(String[] args) {
        int n,m;
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        List<List<Pair>> table = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());           //n,m 입력
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            table.add(new ArrayList<>());               //indexoutofBound 예외를 피하기 위해 리스트들을 만들어 줌.
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st2 = new StringTokenizer(scanner.nextLine());
            int from = Integer.parseInt(st2.nextToken());
            int to = Integer.parseInt(st2.nextToken());
            int length = Integer.parseInt(st2.nextToken());
            table.get(from).add(new Pair(to, length));
            table.get(to).add(new Pair(from, length));          //table 에 {연걸점, 거리} 를 pair 로 만들어 저장한당.
        }

        for (int tc = 0; tc < m; tc++) {
            StringTokenizer st3 = new StringTokenizer(scanner.nextLine());
            int from = Integer.parseInt(st3.nextToken());
            int to = Integer.parseInt(st3.nextToken());

            int[] visited = new int[1002];                  // from 부터 to 까지의 거리를 DFS 를 통해 구한다!
            Queue<Integer> q = new LinkedList<>();

            q.add(from);
            visited[from] = 1;
            while (!q.isEmpty()) {
                int cur = q.peek(); q.remove();
                for (int i = 0; i < table.get(cur).size(); i++) {
                    if (visited[table.get(cur).get(i).to] == 0) {
                        q.add(table.get(cur).get(i).to);
                        visited[table.get(cur).get(i).to] = visited[cur] + table.get(cur).get(i).length;
                    }
                }
            }
            System.out.println(visited[to]-1);
        }
    }

    public static class Pair {
        int to;
        int length;

        Pair(int a, int b) {
            this.to = a;
            this.length = b;
        }
    }
}
