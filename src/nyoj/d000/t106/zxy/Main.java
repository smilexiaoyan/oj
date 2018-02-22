package nyoj.d000.t106.zxy;

//AC

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            S[] s = new S[n];
            for (int i = 0; i < n; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                s[i] = new S(v, w);
            }
            Arrays.sort(s);
            int M = m;
            int i = 0;
            int sum = 0;
            while (i < n && M - s[i].w > 0) {
                sum += s[i].cv();
                M -= s[i].w;
                i++;
            }
            if (i < n) {
                sum += M * s[i].v;
            }
            System.out.println(sum);
        }
    }
}

class S implements Comparable<S> {
    int v;
    int w;

    S(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public int cv() {
        return this.v * this.w;
    }

    @Override
    public String toString() {
        return v + " " + w;
    }

    @Override
    public int compareTo(S o) {// 倒序排序
        if (this.v < o.v) {
            return 1;
        }
        if (this.v > o.v) {
            return -1;
        }
        return 0;
    }
}
