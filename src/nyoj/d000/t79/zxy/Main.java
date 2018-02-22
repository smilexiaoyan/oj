package nyoj.d000.t79.zxy;

//AC

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int m = sc.nextInt();
            int h[] = new int[m];
            for (int i = m - 1; i >= 0; i--) {
                h[i] = sc.nextInt();
            }
            int[] f = new int[m];
            int MAX = 0;
            for (int i = 0; i < m; i++) {
                int max = 1;
                for (int j = 0; j < i; j++) {
                    if (h[i] > h[j] && f[j] + 1 > max) {
                        max = f[j] + 1;
                        if (max > MAX) {
                            MAX = max;
                        }
                    }
                }
                f[i] = max;
            }
            System.out.println(MAX);
        }
    }
}
