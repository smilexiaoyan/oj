package nyoj.d000.t289.zxy;

//AC
import java.util.Scanner;

public class Main3 {

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
			System.out.println(f(n - 1, v, s, map));
			n = sc.nextInt();
			v = sc.nextInt();
		}
	}

	public static int f(int d, int w, int[][] s, int[][] map) {
		if (d == -1) {
			return 0;
		}
		if (s[d][w] == -1) {
			int a = 0;
			if (w >= map[d][0]) {
				a = f(d - 1, w - map[d][0], s, map) + map[d][1];
			}
			s[d][w] = Math.max(f(d - 1, w, s, map), a);
		}
		return s[d][w];
	}
}
