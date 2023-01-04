import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {

    /**
     * [문제 설명]
     *
     * 노드의 개수와 연결된 두 개의 노드를 입력받습니다
     *
     * 연결 상태를 2차원 배열에 저장합니다
     *
     * 이때 (1, 6) 을 [1][6] 과 [6][1]에 저장하려고 한다면 최대 100,000개 이므로
     * 100,000 * 100,000 , 100억개 만큼의 메모리가 필요합니다
     *
     * 이를 해결하기 위해 그래프의 연결 상태만 저장합니다
     *
     * (1, 6) -> 1 열에 6 저장
     *
     * 루트 노드인 1 부터 DFS 를 통해 부모 노드를 얻습니다
     */

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int[] parentsNode = new int[n + 1];

        dfs(tree, parentsNode, 1, 0);

        for (int j = 2; j < n + 1; j++) {
            System.out.println(parentsNode[j]);
        }

    }
    public static void dfs(ArrayList<ArrayList<Integer>> tree, int[] parentsNode, int nodeIndex, int parentsIndex) {
        parentsNode[nodeIndex] = parentsIndex;

        for (int index : tree.get(nodeIndex)) {
            if (index != parentsIndex)
                dfs(tree, parentsNode, index, nodeIndex);
        }
    }

    public static void main (String[] args) throws IOException {
        new BOJ11725().solution();
    }
}