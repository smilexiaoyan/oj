package leetcode.d003.t39;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        long start = System.currentTimeMillis();
        final List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        long end = System.currentTimeMillis();
        System.out.println(lists);
        System.out.println("size: " + lists.size());
        System.out.println("time: " + (end - start));
    }

}
