import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 이해]
 *
 * 문제의 그림에서 각 숫자가 위치한 좌표의 의미를 다음과 같이 해석할 수 있습니다
 *
 * 세로 값 = level
 * 가로 값 = 중위순회 순서
 *
 * [문제 해결]
 *
 * 1. 루트 노드가 무조건 1이 아닙니다 루트 노드를 찾습니다
 *      - 노드의 인스턴스 변수 parents 선언 후 -1로 초기화
 *      - 자식 노드들의 입력값을 받을 때 -1 입력값이 -1이 아니라면 node[son].parents = nodeNumber 로 parents 할당
 *      - 루트 노드는 중위 순회를 위한 첫 시작점으로 쓰임
 *
 * 2. DFS 를 통해 중위 순회를 합니다
 *      - level 을 기준으로 방문 순서별로 왼쪽값 오른쪽 값을 저장
 *      - 왼쪽 값은 해당 level 배열 값 중 가장 작은 값을 저장
 *      - 오른쪽 값은 col 값을 저장하고 다음을 위해 ++
 *
 * 3. level 별로 서로 다른 col 값을 저장했다면 각 차이값을 통해 width 를 구하고 최대 값을 산출합니다
 */

public class BOJ02250 {

    static class Node {
        int parents;
        int number;
        int left;
        int right;

        public Node(int parents, int number, int left, int right) {
            this.parents = parents;
            this.number = number;
            this.left = left;
            this.right = right;
        }
    }

    static Node[] tree;
    static int[] leftValue, rightValue;
    static int colCount;
    static int root;
    static int depth;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, number, left, right;

        N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        leftValue = new int[N + 1];
        rightValue = new int[N + 1];

        for (int i = 1; i< N + 1; i++) {
            tree[i] = new Node(-1, i, -1, -1);
            leftValue[i] = N + 1;
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            tree[number].left = left;
            tree[number].right = right;
            if (left != -1)
                tree[left].parents = number;
            if (right != -1)
                tree[right].parents = number;
        }
//        1. 루트 노드 찾기
        for (int i = 1; i < N + 1; i++ ) {
            if (tree[i].parents == -1)
                root = i;
        }
//        중위 순회를 통해 레벨 별 왼쪽 col 값, 오른쪽 col 값 저장
        colCount = 1;
        dfs(root, 1);

//        3. 가장 큰 width 산출
        int width;
        int row = 1;
        int tmpWidth = rightValue[1] - leftValue[1] + 1;
        for (int i = 2; i < depth + 1; i++) {
            width = rightValue[i] - leftValue[i] + 1;
            if (tmpWidth < width){
                tmpWidth = width;
                row = i;
            }
        }
        System.out.println(row + " " + tmpWidth);
    }
    public void dfs(int number, int level) {
        Node node = tree[number];

        if (depth < level)
            depth = level;

        if (node.left != -1)
            dfs(node.left, level + 1);

        leftValue[level] = Math.min(leftValue[level], colCount);
        rightValue[level] = colCount++;

        if (node.right != -1)
            dfs(node.right, level + 1);
    }

    public static void main(String[] args) throws IOException{
        new BOJ02250().solution();
    }
}
