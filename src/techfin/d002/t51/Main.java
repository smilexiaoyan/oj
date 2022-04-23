package techfin.d002.t51;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        long start = System.currentTimeMillis();
        final List<List<String>> lists = solution.solveNQueens(4);
        long end = System.currentTimeMillis();
        System.out.println(lists);
        System.out.println("time: " + (end - start));
    }
}
