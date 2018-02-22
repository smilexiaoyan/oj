package nyoj.d000.t44.zxy;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
	static int[] map = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0) {
			int n = sc.nextInt();
			map = new int[n];
			LinkedList<Integer> lm = new LinkedList<Integer>();
			int ii = 0;
			for (int i = 0; i < n; i++) {
				int t = sc.nextInt();
				if (map[ii] < 0) {
					if (t < 0) {
						map[ii] += t;
					} else {
						map[++ii] += t;
					}
				} else {
					if (t < 0) {
						map[++ii] += t;
					} else {
						map[ii] += t;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.print(map[i] + " ");
			}

		}
	}

	public static int f(int a, int b) {
		if (a > b) {
			return 0;
		}
		if (a == b) {
			return map[a] < 0 ? 0 : map[a];
		}
		if (map[a] <= 0) {
			return f(a + 1, b);
		}
		if (map[b] <= 0) {
			return f(a, b - 1);
		}

		return (Integer) null;
	}
}
