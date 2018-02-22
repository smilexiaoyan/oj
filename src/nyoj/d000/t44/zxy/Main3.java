package nyoj.d000.t44.zxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {

	static ArrayList<Integer> mp = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0) {
			int n = sc.nextInt();
			LinkedList<Integer> lm = new LinkedList<Integer>();
			lm.add(sc.nextInt());
			for (int i = 1; i < n; i++) {
				int t = sc.nextInt();
				if (lm.getLast() < 0) {
					if (t < 0) {
						t += lm.getLast();
						lm.removeLast();
						lm.add(t);
					} else {
						lm.add(t);
					}
				} else {
					if (t < 0) {
						lm.add(t);
					} else {
						t += lm.getLast();
						lm.removeLast();
						lm.add(t);
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
			}
			f(lm);
			int res = 0;
			Iterator<Integer> it = mp.iterator();
			while (it.hasNext()) {
				Integer integer = (Integer) it.next();
				if (integer > res) {
					res = integer;
				}
			}
			System.out.println(res);
		}
	}

	public static void f(LinkedList<Integer> lm) {
		if (lm.size() == 0) {
			mp.add(0);
			return;
		}
		if (lm.size() == 1) {
			mp.add(lm.getFirst());
			return;
		}
		int a = lm.pop();
		int b = lm.pop();
		int c = a + b;
		if (c >= 0) {
			c += lm.pop();
			lm.push(c);
			f(lm);
			return;
		}
		mp.add(a);
		f(lm);
		return;
	}
}
