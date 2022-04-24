package techfin.d001.t479;

public class Solution {

    public static void main(String[] args) {
        new Solution().largestPalindrome(3);
    }

    public int largestPalindrome(int n) {
        int min = 1;
        for (int i = 1; i < n; i++) {
            min = min * 10;
        }
        int max = min * 10 - 1;
        System.out.println(min);
        System.out.println(max);
        return 0;
    }

    public boolean f(int n, int a, int b) {
        return true;
    }

    public boolean isHuiWen(int num) {
        StringBuilder sb = new StringBuilder(num);
        final String t = sb.toString();
        return t.equals(sb.reverse().toString());
    }

}
