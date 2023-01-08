import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_11725 {

    public static void main(String[] args) {
        int n;
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> table = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int answer[] = new int[100002];

        n = Integer.parseInt(scanner.nextLine());       //n 입력

        for (int i = 0; i <= n; i++) {                  //table 에 빈 배열들을 선언해준다.
            table.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String tmp = scanner.nextLine();
            StringTokenizer st = new StringTokenizer(tmp);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            table.get(first).add(second);
            table.get(second).add(first);               //서로 연걸된 점이므로 table에 저장해준다.
        }

        q.add(1);                                       //DFS 시작
        int visited[] = new int[100002];

        while (!q.isEmpty()) {
            int cur = q.peek();
            visited[cur] = 1;
            q.remove();
            for (int i = 0; i < table.get(cur).size(); i++) {
                if (visited[table.get(cur).get(i)] != 1) {
                    answer[table.get(cur).get(i)] = cur;
                    q.add(table.get(cur).get(i));
                    visited[table.get(cur).get(i)] = 1;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }


}
