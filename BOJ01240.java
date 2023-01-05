import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [문제 해석]
 *
 * 출발노드와 도착노드 최소 거리를 구하는 문제입니다
 *
 * tree 는 최대 2개의 노드끼리 만난다는 특징이 있습니다
 *
 * 따라서 방문 여부만 체크해준다면 최소 거리를 구할 수 있습니다
 *
 * 방문 시, visit[] 배열을 0에서 1로 변경하거나
 * 전체 방문 데이터를 다룰필요 없이, 이전 방문했던 노드인지 아닌지만 체크해줘도 됩니다
 * (한붓 그리기의 답이 단 하나 뿐이다)
 */

public class BOJ01240 {

    /**
     * Node class 를 활용해 값을 저장합니다
     * 가리키는 next 와, distance 를 나타내는 value 가 존재합니다
     */
    public static ArrayList<ArrayList<Node>> tree;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /**
         * 저장공간을 고려해 row 노드에 연결된 노드를 저장합니다
         * 3차원 배열에 행렬 식으로 저장할 시 1000 * 1000 * 1000(distance)
         */
        tree = new ArrayList<>();
        for (int k = 0; k < N + 1; k++) {
            tree.add(new ArrayList<>());
        }

        /**
         * 1 4 의 경우 row 1에 4의 노드를 저장함과 동시에
         *           row 4에 1의 노드 값도 함께 저장합니다
         */
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            tree.get(start).add(new Node(end, distance));
            tree.get(end).add(new Node(start, distance));
        }

        for (int j = 0; j < M; j++) {
            boolean[]  visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dfs(visited, start, end, 0);
        }
    }

    public static void dfs(boolean[] visited, int visitNode, int desNode, int totalDistance) {
        visited[visitNode] = true;  // 방문 시, 방문처리

        for (Node linkedNode : tree.get(visitNode)) {   // 연결된 노드를 순차적으로 순환
            if (visitNode == desNode) {          // 종료조건 : 현재 위치한 노드가 찾고있는 노드
                System.out.println(totalDistance);
                return ;    // 반드시 닫아주기
            }
            else if (!visited[linkedNode.next]) {
                dfs(visited, linkedNode.next, desNode, totalDistance + linkedNode.value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new BOJ01240().solution();
    }
}

class Node {
    int next;
    int value;

    public Node(int next, int value) {
        this.next = next;
        this.value = value;
    }
}
