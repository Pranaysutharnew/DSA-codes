package Recursion.Medium;

public class Leetcode_1922 {
//    Input: n = 1
//    Output: 5
//    Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
//    Example 2:
//    Input: n = 4
//    Output: 400
//    Example 3:
//    Input: n = 50
//    Output: 564908303
    public static void main(String[] args) {
        long n = 1;
        System.out.println(countGoodNumbers(4));
    }

    private static final long MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        long res = findPower(5, (n + 1) / 2);
        long res1 = findPower(4, n / 2);
        return (int) (res * res1 % MOD);
    }

    private static long findPower(int a, long b) {
        if(b == 0){
            return 1;
        }
        long half = findPower(a, b / 2) % MOD;
        long result = (half * half) % MOD;
        if (b % 2 == 1){
            result = (result * (a % MOD)) % MOD;
        }
        return result;
    }
}
