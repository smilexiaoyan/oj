package leetcode.d005.t675;

import java.util.*;
import java.util.stream.Collectors;

class Solution_4 {

    static class Pos {

        public int x;

        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (!(o instanceof Pos)) {return false;}
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    Map<Pos, int[][]> asl_map = new HashMap<>();

    final HashMap<Pos, Pos> p2p = new HashMap<>();

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

        final List<Pos> c = map.keySet().stream().sorted().map(map::get).collect(Collectors.toList());
        final Iterator<Pos> iterator = c.iterator();
        Pos prev = iterator.next();
        while (iterator.hasNext()) {
            Pos p = iterator.next();
            p2p.put(p, prev);
            prev = p;
        }

        final List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        int[][] asl = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(asl[i], -1);
        }
        f(forest, asl, 0, 0, 0);
        asl_map.put(new Pos(0, 0), asl);
        f1(asl, 0, 0);

        Pos current = new Pos(0, 0);
        int result = 0;
        for (int k : collect) {
            final Pos dst = map.get(k);
            int[][] asl_current = asl_map.get(dst);
            if (asl_current == null || asl_current[current.x][current.y] < 0) {
                return -1;
            }
            result += asl_current[current.x][current.y];
            current = dst;
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
        if (asl[x][y] >= 0 && value >= asl[x][y]) {
            return;
        }
        asl[x][y] = value;

        f(forest, asl, x - 1, y, value + 1);
        f(forest, asl, x + 1, y, value + 1);
        f(forest, asl, x, y - 1, value + 1);
        f(forest, asl, x, y + 1, value + 1);
    }

    void f1(int[][] asl, int x, int y) {
        final Pos src = new Pos(x, y);

        f2(asl, src, new Pos(x - 1, y));
        f2(asl, src, new Pos(x + 1, y));
        f2(asl, src, new Pos(x, y - 1));
        f2(asl, src, new Pos(x, y + 1));
    }

    void f2(int[][] asl, Pos src, Pos dst) {
        if (outOfBound(asl, dst.x, dst.y)) {
            return;
        }
        if (asl_map.containsKey(dst)) {
            return;
        }
        final int[][] asl0 = asl_map.get(new Pos(0, 0));
        if (asl0[dst.x][dst.y] <= asl0[src.x][src.y]) {
            return;
        }
        int[][] next_asl = new int[asl.length][asl[0].length];
        for (int[] ints : next_asl) {
            Arrays.fill(ints, -1);
        }
        f3(asl, next_asl, dst.x, dst.y, asl[src.x][src.y], -1);
        f3(asl, next_asl, src.x, src.y, -1, 1);
        asl_map.put(dst, next_asl);

        f2(next_asl, dst, new Pos(dst.x - 1, dst.y));
        f2(next_asl, dst, new Pos(dst.x + 1, dst.y));
        f2(next_asl, dst, new Pos(dst.x, dst.y - 1));
        f2(next_asl, dst, new Pos(dst.x, dst.y + 1));
    }

    void f3(int[][] asl, int[][] dst_asl, int x, int y, int value, int dist) {
        if (outOfBound(asl, x, y)) {
            return;
        }
        if (asl[x][y] <= value) {
            return;
        }
        if (dst_asl[x][y] != -1) {
            return;
        }
        dst_asl[x][y] = asl[x][y] + dist;

        f3(asl, dst_asl, x - 1, y, asl[x][y], dist);
        f3(asl, dst_asl, x + 1, y, asl[x][y], dist);
        f3(asl, dst_asl, x, y - 1, asl[x][y], dist);
        f3(asl, dst_asl, x, y + 1, asl[x][y], dist);
    }

    boolean outOfBound(int[][] asl, int x, int y) {
        return x < 0 || y < 0 || x >= asl.length || y >= asl[0].length || asl[x][y] < 0;
    }

}