package leetcode.d005.t675;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    static class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        Map<Integer, Pos> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final List<Integer> row = forest.get(i);
            for (int j = 0; j < n; j++) {
                Integer item = row.get(j);
                if (item > 1) {
                    map.put(item, new Pos(i, j));
                }
            }
        }
        final List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        Pos current = new Pos(0, 0);
        int result = 0;
        for (int k : collect) {
            final Pos pos = map.get(k);
            int[][] asl = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(asl[i], Integer.MAX_VALUE);
            }
            f(forest, asl, pos.x, pos.y, 0);
            if (asl[current.x][current.y] == Integer.MAX_VALUE) {
                return -1;
            }
            result += asl[current.x][current.y];
            current = pos;
        }
        return result;
    }

    void f(List<List<Integer>> forest, int[][] asl, int x, int y, int value) {
        if (x < 0 || y < 0 || x >= asl.length || y >= asl[0].length) {
            return;
        }
        if (forest.get(x).get(y) == 0) {
            return;
        }
        if (value >= asl[x][y]) {
            return;
        }
        asl[x][y] = value;
        f(forest, asl, x - 1, y, value + 1);
        f(forest, asl, x + 1, y, value + 1);
        f(forest, asl, x, y - 1, value + 1);
        f(forest, asl, x, y + 1, value + 1);
    }
}