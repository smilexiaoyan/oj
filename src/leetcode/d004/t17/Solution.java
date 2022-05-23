package leetcode.d004.t17;


import java.util.Arrays;

public class Solution {

    public int[] missingTwo(int[] nums) {
        int N = nums.length + 2;
        int temp = xorAll(N);
        for (int num : nums) {
            temp ^= num;
        }
        int flag = 1;
        while ((flag & temp) == 0) {
            flag <<= 1;
        }
        int m = 0;
        for (int i = 0; i < N; i++) {
            if ((flag & (i + 1)) != 0) {
                m ^= i + 1;
            }
            if (i < nums.length) {
                if ((flag & nums[i]) != 0) {
                    m ^= nums[i];
                }
            }
        }
        return new int[]{m, temp ^ m};
    }

    public int xorAll(int n) {
        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            case 3:
                return 0;
            default:
                throw new RuntimeException();

        }
    }

}
