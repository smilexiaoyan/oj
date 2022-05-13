package leetcode.d003.t39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> r = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        f(candidates, 0, target);
        return result;
    }

    public void f(int[] candidates, int index, int target) {
        System.out.println(r);
        if (target == 0) {
            result.add(new ArrayList<>(r));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        final int remain = target - candidates[index];
        if (remain >= 0) {
            r.addLast(candidates[index]);
            f(candidates, index, remain);
            r.removeLast();
        }
        f(candidates, index + 1, target);
    }

}
