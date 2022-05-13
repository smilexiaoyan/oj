package leetcode.d004.t17;

public class Test {

    public static void main(String[] args) {
        int m = 0;
        for (int i = 1; i < 10; i++) {
            m ^= i;
            System.out.println("i = " + i + ", " + m);
        }
    }

}
