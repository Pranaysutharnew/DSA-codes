package Recursion.Easy;

public class Leetcode_509 {
//    Input: n = 2
//    Output: 1
//    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//    Example 2:
//    Input: n = 3
//    Output: 2
//    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//    Example 3:
//    Input: n = 4
//    Output: 3
//    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        return fiboSum(n, 0, 1, 0);
    }

    private static int fiboSum(int n, int num1, int num2, int idx) {
        if (idx == n){// 0 1 1 2
            return num1;
        }
        return fiboSum(n, num2, num1 + num2, idx + 1);
    }

}
