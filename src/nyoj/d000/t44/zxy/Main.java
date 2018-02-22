package nyoj.d000.t44.zxy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0) {
			int n = sc.nextInt();
			int[] ma = new int[n];
			int m = 0;
			int t = 0;
			for (int i = 0; i < n; i++) {
				int q = sc.nextInt();
				if (t < 0) {
					if (q < 0) {
						t += q;
					} else {
						ma[m++] = t;
						t = q;
					}
				} else {
					if (q < 0) {
						ma[m++] = t;
						t = q;
					} else {
						t += q;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.print(ma[i] + " ");
			}

		}
	}
}
