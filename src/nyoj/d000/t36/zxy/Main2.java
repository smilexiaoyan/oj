package nyoj.d000.t36.zxy;

//修改 Main.java

import java.util.Scanner;

public class Main2 {
    static char[] a = null;
    static char[] b = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while (N-- > 0) {
            a = sc.nextLine().toCharArray();
            b = sc.nextLine().toCharArray();
            int[][] f = new int[a.length][b.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    f[i][j] = -1;
                }
            }
            System.out.println(d(f, a.length - 1, b.length - 1));
        }
        sc.close();
    }

    public static int d(int[][] f, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (f[m][n] == -1) {
            f[m][n] = Math.max(
                    Math.max(d(f, m - 1, n - 1) + same(m, n), d(f, m - 1, n)),
                    d(f, m, n - 1));
        }
        return f[m][n];
    }

    public static int same(int m, int n) {
        if (a[m] == b[n]) {
            return 1;
        } else {
            return 0;
        }
    }
}
