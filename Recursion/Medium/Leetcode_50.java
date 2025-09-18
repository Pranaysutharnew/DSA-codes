package Recursion.Medium;

public class Leetcode_50 {
//    Input: x = 2.00000, n = 10
//    Output: 1024.00000
//    Example 2:
//    Input: x = 2.10000, n = 3
//    Output: 9.26100
//    Example 3:
//    Input: x = 2.00000, n = -2
//    Output: 0.25000
//    Explanation: 2-2 = 1/22 = 1/4 = 0.25
    public static void main(String[] args) {
        System.out.println();
    }

    public static  double myPow(double x, int n) {
        // if n is positive
        if (n > 0){
            return pasPow(x, n);
        }
        else{
            return 1.0 / pasPow(x, n);
        }
    }
    public static double pasPow(double x, int n){
        if(n == 0){
            return 1.0;
        }
        double half = pasPow(x, n / 2);
        double res = half * half;

        if(n % 2 == 1){
            res = res * x;
        }
        return res;
    }
}
