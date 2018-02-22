package nyoj.d000.t51.zxy;

//AC

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int L = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[L + 1];
            int res = L + 1;
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                for (int j = a; j <= b; j++) {
                    if (arr[j] != 1) {
                        arr[j] = 1;
                        res--;
                    }
                }
            }
            System.out.println(res);
        }
    }

}
