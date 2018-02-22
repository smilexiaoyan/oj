package nyoj.d000.t28.zxy;

//AC

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1;
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i < n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        System.out.println(res);
    }
}
