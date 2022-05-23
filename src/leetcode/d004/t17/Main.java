package leetcode.d004.t17;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        long start = System.currentTimeMillis();
        int[] lists = solution.missingTwo(new int[]{3});
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(lists));
        System.out.println("size: " + lists.length);
        System.out.println("time: " + (end - start));
    }

}
