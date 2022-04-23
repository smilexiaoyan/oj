package techfin.d002.t51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] map = new int[n];
        for (int i = 0; i < map.length; i++) {
            map[i] = i;
        }
        p(map, 0);
        return result;
    }

    public void p(int[] map, int n) {
        if (n == map.length - 1) {
            for (int a = 0; a < map.length; a++) {
                int b = map[a];
                for (int x = a + 1; x < map.length; x++) {
                    int y = map[x];
                    if (!isCorrect(a, b, x, y)) {
                        return;
                    }
                }
            }
            append(map);
            return;
        }
        for (int i = n; i < map.length; i++) {
            swap(map, n, i);
            p(map, n + 1);
            swap(map, n, i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public boolean isCorrect(int a, int b, int x, int y) {
        if (x == a || y == b) {
            return false;
        }
        int d = Math.abs(y - b);
        return x != a + d && x != a - d;
    }

    private void append(int[] map) {
        final List<String> res = new ArrayList<>(map.length);
        for (int k : map) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < map.length; j++) {
                sb.append(j == k ? "Q" : ".");
            }
            res.add(sb.toString());
        }
        result.add(res);
    }

}
