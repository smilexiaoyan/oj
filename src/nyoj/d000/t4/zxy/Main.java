package nyoj.d000.t4.zxy;

//AC

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            String str = sc.next();
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            int len = ch.length;
            for (int i = 0; i < len; i++) {
                System.out.print(ch[i] + " ");
            }
            System.out.println();
        }
    }
}
