import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_2078 {

    public static void main(String[] args) {
        long a,b;
        Scanner scanner = new Scanner(System.in);
        long x = 0;
        long y = 0;
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());     //a,b

        while (!(a == 1 && b == 1)) {
            if (a < b) {
                b -= a;
                x++;
            } else {
                a -= b;
                y++;
            }
        }
        System.out.println(y + " " + x);

    }
}
