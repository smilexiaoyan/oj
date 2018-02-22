package nyoj.d000.t90.zxy;

//AC

import java.util.Scanner;

public class Main {
    static int[][] mm = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        while (M-- > 0) {
            int n = sc.nextInt();
            mm = new int[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    mm[i][j] = -1;
                }
            }
            System.out.println(f(n, n));
        }
    }

    public static int f(int n, int m) {
        if (mm[n][m] == -1) {
            if (n == 1 || m == 1) {
                mm[n][m] = 1;
            } else if (n < m) {
                mm[n][m] = f(n, n);
            } else if (n == m) {
                mm[n][m] = 1 + f(n, n - 1);
            } else {
                mm[n][m] = f(n - m, m) + f(n, m - 1);
            }
        }
        return mm[n][m];
    }
}
