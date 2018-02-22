package nyoj.d002.t11.zxy;

// 无法提交

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int n = sc.nextInt();
            StringBuffer sbo = new StringBuffer();
            StringBuffer sbj = new StringBuffer();
            for (int i = 1; i < n; i += 2) {
                sbj.append(i + " ");
                sbo.append((i + 1) + " ");
            }
            System.out.println(sbj.toString() + "\n" + sbo.toString());
        }
    }
}
