package nyoj.d000.t23.zxy;

//AC

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int o = sc.nextInt();
        while (o-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] fl = new int[N + 1];
            for (int i = 1; i <= M && i <= N; i++) {
                fl[i] = 1;
            }
            for (int i = M + 1; i <= N; i++) {
                for (int j = i - M; j < i; j++) {
                    if (fl[j] == 0) {
                        fl[i] = 1;
                        break;
                    }
                }
            }
            System.out.println(fl[N] == 1 ? "Win" : "Lose");

            // for (int i = N-1; i > -1; i--) {
            // System.out.print(i + "\t");
            // }
            // System.out.println();
            // for (int i = 1; i <= N; i++) {
            // System.out.print(fl[i] + "\t");
            // }
        }
    }

}
