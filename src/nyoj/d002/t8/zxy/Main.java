package nyoj.d002.t8.zxy;

//AC

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int m = sc.nextInt();
            Range[] rarr = new Range[m];
            for (int i = 0; i < m; i++) {
                rarr[i] = new Range(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(rarr);
            for (int i = 0; i < m; i++) {
                System.out.print(rarr[i]);
            }
        }
    }
}

class Range implements Comparable {
    public int n;
    public int l;
    public int w;

    public boolean dead = false;

    public Range(int n, int l, int w) {
        this.n = n;
        if (w > l) {
            this.l = w;
            this.w = l;
            return;
        }
        this.l = l;
        this.w = w;
    }

    @Override
    public int compareTo(Object o) {
        Range r = (Range) o;
        if (this.n > r.n) {
            return 1;
        } else if (this.n < r.n) {
            return -1;
        }
        if (this.l > r.l) {
            return 1;
        } else if (this.l < r.l) {
            return -1;
        }
        if (this.w > r.w) {
            return 1;
        } else if (this.w < r.w) {
            return -1;
        }
        dead = true;
        return 0;
    }

    @Override
    public String toString() {
        if (dead) {
            return "";
        }
        return this.n + " " + this.l + " " + this.w + "\n";
    }
}
