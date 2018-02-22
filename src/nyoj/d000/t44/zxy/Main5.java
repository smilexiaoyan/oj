package nyoj.d000.t44.zxy;

//AC

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int n = sc.nextInt();
            int max = sc.nextInt();
            int t = max;
            int i = 1;
            while (t < 0 && i < n) {
                t = sc.nextInt();
                if (t > max) {
                    max = t;
                }
                i++;
            }
            int p = 0;
            while (i < n) {
                int m = sc.nextInt();

                if (m < 0) {
                    p += m;
                } else {
                    if (p == 0) {
                        t += m;
                        if (t > max) {
                            max = t;
                        }
                    } else {

                        if (t + p > 0) {
                            t += p + m;
                        } else {
                            if (t > max) {
                                max = t;
                            }
                            t = m;
                        }
                        if (t > max) {
                            max = t;
                        }
                        p = 0;
                    }
                }

                i++;
            }
            System.out.println(max);
        }
    }
}
