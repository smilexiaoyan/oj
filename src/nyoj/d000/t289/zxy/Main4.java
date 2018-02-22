package nyoj.d000.t289.zxy;

//TimeLimitExceeded	不使用数组保存局部解
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), v = sc.nextInt();
		while (n != 0 || v != 0) {
			int map[][] = new int[n][2];
			for (int i = 0; i < n; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			int[][] s = new int[n][v + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < v + 1; j++) {
					s[i][j] = -1;
				}
			}
			System.out.println(f(n - 1, v, map));
			n = sc.nextInt();
			v = sc.nextInt();
		}
	}

	public static int f(int d, int w, int[][] map) {
		if (d == -1) {
			return 0;
		}
		int a = 0;
		if (w >= map[d][0]) {
			a = f(d - 1, w - map[d][0], map) + map[d][1];
		}
		return Math.max(f(d - 1, w, map), a);
	}

}
