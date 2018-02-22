package nyoj.d000.t289.zxy;

//TimeLimitExceeded
import java.util.Scanner;

public class Main {
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), v = sc.nextInt();
		while (n != 0 && v != 0) {
			int map[][] = new int[n][2];
			for (int i = 0; i < n; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			f(0, map, v, 0);
			System.out.println(max);
			n = sc.nextInt();
			v = sc.nextInt();
			max = 0;
		}
	}

	public static void f(int d, int[][] map, int w, int v) {
		if (w < 0) {
			return;
		}
		if (d == map.length) {
			if (v > max) {
				max = v;
			}
			return;
		}
		f(d + 1, map, w, v);
		if (w >= map[d][0]) {
			f(d + 1, map, w - map[d][0], v + map[d][1]);
		}

	}
}
