package nyoj.d000.t289.zxy;

//TimeLimitExceeded
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), v = sc.nextInt();
		while (!(n == 0 && v == 0)) {
			int map[][] = new int[n][2];
			for (int i = 0; i < n; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			int[] s = new int[n];
			for (int i = 0; i < n; i++) {
				s[i] = -1;
			}
			System.out.println(f(0, v, 0, s, map));
			n = sc.nextInt();
			v = sc.nextInt();
		}
	}

	public static int f(int n, int w, int v, int[] s, int[][] map) {
		if (n >= map.length) {
			return v;
		}
		if (w == 0) {
			return v;
		}
		int a = f(n + 1, w, v, s, map);
		int b = 0;
		if (w >= map[n][0]) {
			b = f(n + 1, w - map[n][0], v + map[n][1], s, map);
		}
		if (b > a) {
			a = b;
		}
		return a;
	}
}
