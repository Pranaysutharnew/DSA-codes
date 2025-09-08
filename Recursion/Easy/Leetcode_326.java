package Recursion.Easy;

public class Leetcode_326 {
//    Input: n = 27
//    Output: true
//    Explanation: 27 = 33
//    Example 2:
//
//    Input: n = 0
//    Output: false
//    Explanation: There is no x where 3x = 0.
//    Example 3:
//
//    Input: n = -1
//    Output: false
//    Explanation: There is no x where 3x = (-1).
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
