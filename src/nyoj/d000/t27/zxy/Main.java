package nyoj.d000.t27.zxy;

//AC

import java.util.Scanner;

public class Main {
    public static void main(String[] argsf) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int m = sc.nextInt(), n = sc.nextInt();

            int[][] map = new int[m + 2][n + 2];
            for (int i = 0; i <= m + 1; i++) {
                for (int j = 0; j <= n + 1; j++) {
                    if (i == 0 || j == 0 || i == m + 1 || j == n + 1) {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = sc.nextInt();
                    }
                }
            }
            int count = 0;
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    count += find(i, j, map);
                }
            }
            System.out.println(count);
        }
    }

    public static int find(int x, int y, int[][] map) {
        if (map[x][y] == 0) {
            return 0;
        }
        map[x][y] = 0;
        find(x, y + 1, map);// 右边
        find(x + 1, y, map);// 下边
        find(x, y - 1, map);// 左边
        find(x - 1, y, map);// 上面

        return 1;
    }
}
