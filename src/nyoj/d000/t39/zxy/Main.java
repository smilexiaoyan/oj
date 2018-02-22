package nyoj.d000.t39.zxy;

//AC

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int count = f(n);
            if (count == n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static int f(int n) {
        int t = n;
        int count = 0;
        while (t >= 1) {
            int m = t % 10;
            count += Math.pow(m, 3);
            t /= 10;
        }
        return count;
    }
}
