package leetcode.utils;

import java.util.Arrays;

public class Utils {

    public static void print(int[][] a) {
        for (int[] b : a) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }

    public static void print_natural(int[][] a) {
        StringBuilder sb = new StringBuilder();
        for (int[] b : a) {
            sb.append("[");
            for (int i : b) {
                sb.append(i < 0 ? "*" : i);
                sb.append(", ");
            }
            sb.replace(sb.length() - 1, sb.length(), "]");
            sb.append("\n");
        }
        System.out.println(sb);

    }

}
