package nyoj.d000.t17.zxy;

//AC

import java.util.Scanner;

public class Main {
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while (N-- > 0) {
            String s = sc.next();
            char[] sch = s.toCharArray();
            int[] res = new int[sch.length];
            for (int i = 0; i < sch.length; i++) {
                max = Math.max(f(i, sch, res), max);
            }
            System.out.println(max);
            max = 0;
        }
    }

    public static int f(int n, char[] sch, int[] res) {
        if (res[n] == 0) {
            int ret = 1;
            for (int i = 0; i < n; i++) {
                if (sch[n] > sch[i]) {
                    ret = Math.max(ret, f(i, sch, res) + 1);
                }
            }
            res[n] = ret;
        }
        return res[n];
    }

}
