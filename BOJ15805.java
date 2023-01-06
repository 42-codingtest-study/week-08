import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15805 {
    static int count;
    static int[] input;

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Node>> tree = new ArrayList<>();

        count = 0;                  // Node class 를 생성하는 시점에 ++
        input = new int[200001];    // 입력값 최대 공간을 미리 할당
        for (int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());    // 입력값을 재활용하기 위해 배열에 저장
        // stringTokenizer 의 특성상 값을 재활용하려면 다른 곳에 저장을 해둬야 한다

        for (int j = 0; j < 200001; j++) // 노드를 저장할 공간으로 row 를 방문 노드 번호로 사용할 것이다
            tree.add(new ArrayList<>()); // 몇개의 노드가 있는지 바로 모르니 최대 크기로 할당한다
        // 현재 row 만 할당이 되었고, col 은 할당이 없는 상황

        tree.get(input[0]).add(new Node(-1)); // 최소 1개의 노드는 확정적으로 들어온다 setUp

        for (int i = 1; i < N; i++) {
            if (tree.get(input[i]).isEmpty()) { // 처음 방문했다면, 즉 값이 저장되지 않았다면
                tree.get(input[i]).add(new Node(input[i-1])); // 저장하겠다
            }
        }

        System.out.println(count);
        for (int k = 0; k < count; k++) {
            System.out.print(tree.get(k).get(0).parents + " "); // 뒤에 띄어쓰기 하나 더 생기는건 좀 불편...
        }
    }

    public static void main(String[] args) throws IOException {
        new BOJ15805().solution();
    }

    static class Node {
        int parents;

        public Node(int parents) {
            this.parents = parents;
            count++;
        }
    }
}

/**
 *[Error code]
 * 처음에 문제 이해를 잘못했다
 *
 * 무조건 루트 노드로 0이 오고 1씩 커지면서 숫자가 연결되는 줄 알았다
 *
 * 그래서 입력값들 중 현재의 값이 이전 값보다 크다면 무조건 자식 노드로 고려했고
 * 이를 조건문으로 사용했다
 *
 * 이와같은 방식으로 코드를 구현했을 때
 * 2
 * 1 0 같은 입력값에서 IndexOutOfBound 문제가 발생한다
 *
 */

//        int node1 = -1;
//        for (int i = 0; i < N; i++) {
//            int node2 = Integer.parseInt(st.nextToken());
//
//            if (node1 < node2)
//                tree.get(node2).add(new Node(node1));
//            node1 = node2;
//        }
//        System.out.println(count);
//        for (int k = 0; k < count; k++) {
//            System.out.print(tree.get(k).get(0).parents + " ");
//        }

/**
 * 이 문제의 핵심은 어떻게 부모 노드를 저장하고 이미 저장된 노드를 어떻게 구별할 것인가 이다
 *
 * 2차원 ArrayList 를 선언하고
 *
 * 현재 방문한 노드를 row 로 읽고 해당 공간에 부모 노드가 저장된 Node class 를 add 해주면 된다
 *
 * 특히 노드를 처음 방문한 경우, 즉 해당 row 에 값이 저장되지 않는 경우를 확인하는 방법은
 *
 * isEmpty 를 사용하면 된다
 */


