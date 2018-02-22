package nyoj.d000.t37.zxy;

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
            String s = sc.nextLine();
            a = s.toCharArray();
            int len = a.length;
            b = new char[len];
            for (int i = 0; i < len; i++) {
                b[i] = a[len - i - 1];
            }
            int[][] m = new int[len + 1][len + 1];
            for (int i = 0; i < len + 1; i++) {
                for (int j = 0; j < len + 1; j++) {
                    m[i][j] = -1;
                }
            }
            System.out.println(len - f(m, len, len));
        }
    }

    public static int f(int[][] m, int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (m[x][y] == -1) {
            int max = Math.max(f(m, x - 1, y - 1) + same(x, y),
                    Math.max(f(m, x - 1, y), f(m, x, y - 1)));
            m[x][y] = max;
        }
        return m[x][y];
    }

    public static int same(int x, int y) {
        if (a[x - 1] == b[y - 1]) {
            return 1;
        } else {
            return 0;
        }
    }
}
