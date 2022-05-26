package leetcode.d005.t675;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static class Pos {
        public final int x;
        public final int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static Map<Pos, Integer> caches = new HashMap<>();

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
            final Pos dst = map.get(k);
            int cv = forest.get(current.x).get(current.y);
            int pv = forest.get(dst.x).get(dst.y);
            Integer cache = caches.get(cv > pv ? new Pos(pv, cv) : new Pos(cv, pv));
            if (cache != null) {
                result += cache;
                current = dst;
                continue;
            }
            int[][] asl = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(asl[i], Integer.MAX_VALUE);
            }
            Stack<Pos> stack = new Stack<>();
            f(forest, asl, dst.x, dst.y, 0, stack);
            if (asl[current.x][current.y] == Integer.MAX_VALUE) {
                return -1;
            }
            result += asl[current.x][current.y];
            current = dst;
        }
        return result;
    }

    void f(List<List<Integer>> forest, int[][] asl, int x, int y, int value, Stack<Pos> stack) {
        if (x < 0 || y < 0 || x >= asl.length || y >= asl[0].length) {
            return;
        }
        final Integer fv = forest.get(x).get(y);
        if (fv == 0) {
            return;
        }
        if (value >= asl[x][y]) {
            return;
        }
        stack.forEach(item -> {
            final Pos pos;
            final Integer iv = forest.get(item.x).get(item.y);
            if (iv > fv) {
                pos = new Pos(fv, iv);
            } else {
                pos = new Pos(iv, fv);
            }
            caches.put(pos, value - asl[item.x][item.y]);
        });
        asl[x][y] = value;
        stack.push(new Pos(x, y));
        f(forest, asl, x - 1, y, value + 1, stack);
        f(forest, asl, x + 1, y, value + 1, stack);
        f(forest, asl, x, y - 1, value + 1, stack);
        f(forest, asl, x, y + 1, value + 1, stack);
        stack.pop();
    }
}