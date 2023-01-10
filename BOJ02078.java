import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ02078 {

    /**
     * [로직 설명]
     *
     * 해당 문제는 단순 수학 문제입니다
     *
     * 두 숫자 중 어느쪽이 큰 쪽인지에 따라 이동해 온 방향을 알 수 있습니다
     * 큰 숫자를 (큰 숫자 - 작은 숫자)로 수정해주면서 둘 다 1이 될 때까지 진행합니다
     */

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = 0;

        while (!(x == 1 && y == 1)) {
            if (x > y) {
                x -= y;
                left++;
            }
            else {
                y -= x;
                right++;
            }
        }
        System.out.println(left + " " + right);
    }
    public static void main (String[] args) throws IOException {
        new BOJ02078().solution();
    }

    /**
     * [학습]
     * 
     * Java로 문제를 풀면 입력에 시간 초과 문제가 많이 발생합니다
     * 이로인해 
     * Scanner 보다 BufferReader 를 선호합니다
     * Split 보다 StringTokenizer 를 선호합니다
     */
}