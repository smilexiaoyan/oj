package leetcode.d004.t17;

public class Solution {

    public int[] missingTwo(int[] nums) {
        int N = nums.length + 2;
        int sum = (N + 1) * 2;
        System.out.println(sum);
        for (int num : nums) {
            sum ^= num;
        }
        System.out.println(sum);

        return new int[]{};
    }

}
