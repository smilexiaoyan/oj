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
            if (isCorrect(map, map.length)) {
                append(map);
            }
            return;
        }
        // 剪枝
        if (!isCorrect(map, n)) {
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

    public boolean isCorrect(int[] map, int n) {
        for (int a = 0; a < n; a++) {
            int b = map[a];
            for (int x = a + 1; x < n; x++) {
                int y = map[x];
                if (!isContact(a, b, x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isContact(int a, int b, int x, int y) {
        int d = y - b;
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
