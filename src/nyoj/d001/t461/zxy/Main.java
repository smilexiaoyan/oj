package nyoj.d001.t461.zxy;

import java.util.Scanner;

/**
 * Created by zhang on 2018-02-08.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = (int) ((Math.pow((1 + Math.sqrt(5)) / 2, n) - Math.pow((1 - Math.sqrt(5)) / 2, n)) / Math.sqrt(5));

            while (sum > 9999) {
                sum /= 10;
            }
            System.out.println(sum);
        }
    }
}