package nyoj.d000.t42.zxy;

//AC
/*
 * 无向图中判断欧拉的条件：
 * 无向图必须连通
 * 如果它每个点的度都是偶数,那么它存在一条欧拉回路；
 * 如果有且仅有2个点的度为奇数,那么它存在一条欧拉路；
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int[] du = new int[p + 1];
            int[][] map = new int[p + 1][p + 1];
            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[a][b] = 1;
                map[b][a] = 1;
                du[a]++;
                du[b]++;
            }
            int[] fl = new int[p + 1];
            f(map, fl, 1);
            for (int i = p - 1; i > 0; i--) {
                if (fl[i] == 0) {
                    System.out.println("No");
                    return;
                }
            }
            int ji = 0;
            for (int i = 1; i <= p; i++) {
                if (du[i] == 0) {
                    ji = -1;
                    break;
                }
                if (du[i] % 2 == 1) {
                    ji++;
                }
            }
            if (ji == 2 || ji == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static void f(int[][] map, int[] fl, int m) {
        if (fl[m] == 1) {
            return;
        }
        fl[m] = 1;
        for (int i = map.length - 1; i > 0; i--) {
            if (map[m][i] == 1) {
                f(map, fl, i);
            }
        }
    }
}
