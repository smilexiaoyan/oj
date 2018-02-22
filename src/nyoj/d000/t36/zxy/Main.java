package nyoj.d000.t36.zxy;

//AC

import java.util.Scanner;

public class Main {
    static char[] a = null;
    static char[] b = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while (N-- > 0) {
            a = sc.nextLine().toCharArray();
            b = sc.nextLine().toCharArray();
            int[][] f = new int[a.length + 1][b.length + 1];
            for (int i = 0; i < a.length + 1; i++) {
                for (int j = 0; j < b.length + 1; j++) {
                    f[i][j] = -1;
                }
            }
            d(f, a.length, b.length);
            System.out.println(f[a.length][b.length]);
        }
    }

    public static int d(int[][] f, int m, int n) {
        if (f[m][n] == -1) {
            if (m == 0 || n == 0) {
                return 0;
            }
            f[m][n] = Math.max(
                    Math.max(d(f, m - 1, n - 1) + same(m, n), d(f, m - 1, n)),
                    d(f, m, n - 1));
        }
        return f[m][n];
    }

    public static int same(int m, int n) {
        if (a[m - 1] == b[n - 1]) {
            return 1;
        } else {
            return 0;
        }
    }
}
