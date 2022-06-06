package leetcode.d005.t675;

import leetcode.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static class Pos {

        public final static Pos pos0 = new Pos(0, 0);

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

    final HashMap<Pos, Pos> p2p = new HashMap<>();

    Set<Pos> visited = new HashSet<>();

    int sum = 0;

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
            p2p.put(prev, p);
            prev = p;
        }

        int[][] asl0 = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(asl0[i], -1);
        }
        f(forest, asl0, 0, 0, 0);
        final Pos pos = c.get(0);
        sum += asl0[pos.x][pos.y];
        visited.add(Pos.pos0);
        if (!add(asl0, Pos.pos0)) {
            return -1;
        }
        f2(asl0, asl0, Pos.pos0, new Pos(0, 1));
        f2(asl0, asl0, Pos.pos0, new Pos(1, 0));
        return sum;
    }

    boolean add(int[][] asl, Pos src) {
        Pos dst = p2p.remove(src);
        if (dst != null) {
            if (asl[dst.x][dst.y] < 0) {
                p2p.clear();
                sum = -1;
                return false;
            }
            sum += asl[dst.x][dst.y];
            return !p2p.isEmpty();
        }
        return true;
    }

    void f2(int[][] asl0, int[][] prev, Pos src, Pos dst) {
        if (outOfBound(asl0, dst.x, dst.y)) {
            return;
        }
        if (visited.contains(dst)) {
            return;
        }
        if (p2p.isEmpty()) {
            return;
        }
        if (asl0[dst.x][dst.y] <= asl0[src.x][src.y]) {
            return;
        }
        int[][] asl = new int[prev.length][prev[0].length];
        for (int[] ints : asl) {
            Arrays.fill(ints, -1);
        }
        f3(prev, asl, dst.x, dst.y, prev[src.x][src.y], -1);
        f3(prev, asl, src.x, src.y, -1, 1);
        visited.add(dst);
        if (!add(asl, dst)) {
            return;
        }

        f2(asl0, asl, dst, new Pos(dst.x - 1, dst.y));
        f2(asl0, asl, dst, new Pos(dst.x + 1, dst.y));
        f2(asl0, asl, dst, new Pos(dst.x, dst.y - 1));
        f2(asl0, asl, dst, new Pos(dst.x, dst.y + 1));
    }

    void f3(int[][] prev, int[][] asl, int x, int y, int v, int dist) {
        if (outOfBound(prev, x, y)) {
            return;
        }
        if (prev[x][y] <= v) {
            return;
        }
        if (asl[x][y] != -1) {
            return;
        }
        asl[x][y] = prev[x][y] + dist;
        f3(prev, asl, x - 1, y, prev[x][y], dist);
        f3(prev, asl, x + 1, y, prev[x][y], dist);
        f3(prev, asl, x, y - 1, prev[x][y], dist);
        f3(prev, asl, x, y + 1, prev[x][y], dist);
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

    boolean outOfBound(int[][] asl, int x, int y) {
        return x < 0 || y < 0 || x >= asl.length || y >= asl[0].length || asl[x][y] < 0;
    }

}