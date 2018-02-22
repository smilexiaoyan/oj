package nyoj.d000.t44.zxy;

import java.util.LinkedList;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0) {
			int n = sc.nextInt();
			LinkedList<Integer> lm = new LinkedList<Integer>();
			int max = sc.nextInt();
			lm.add(max);
			for (int i = 1; i < n; i++) {
				int t = sc.nextInt();
				if (t > max) {
					max = t;
				}
				if (lm.getFirst() < 0) {
					if (t < 0) {
						t += lm.getFirst();
						lm.pop();
						lm.push(t);
					} else {
						lm.push(t);
					}
				} else {
					if (t < 0) {
						lm.push(t);
					} else {
						t += lm.getFirst();
						lm.pop();
						lm.push(t);
					}
				}
			}
			if (lm.getFirst() <= 0) {
				lm.removeFirst();
			}
			if (lm.size() > 0) {
				if (lm.getLast() <= 0) {
					lm.removeLast();
				}
			} else {
				System.out.println(max);
				return;
			}
			while (lm.size() > 1) {
				int a = lm.pop();
				int b = lm.pop();
				int c = a + b;
				if (c > 0) {
					c += lm.pop();
					lm.push(c);
					continue;
				}
				if (a > max) {
					max = a;
				}
			}
			if (lm.size() == 0) {
				System.out.println(max);
				return;
			}
			if (lm.size() == 1) {
				if (lm.getFirst() > max) {
					max = lm.getFirst();
				}
			}
			System.out.println(max);
		}
	}
}
