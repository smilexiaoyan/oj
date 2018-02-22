package nyoj.d000.t76.zxy;

//AC

import java.util.Scanner;

public class Main {
    static int[] map = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map[1] = 1;
        map[2] = 1;
        while (N-- > 0) {
            int k = sc.nextInt();
            if (k == 1) {
                System.out.println(0);
            } else {
                System.out.println(f(k));
            }
        }
    }

    public static int f(int m) {
        if (map[m] == 0) {
            map[m] = f(m - 1) + f(m - 2);
        }
        return map[m];
    }
}
