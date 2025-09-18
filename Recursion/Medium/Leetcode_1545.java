package Recursion.Medium;

public class Leetcode_1545 {
//    Input: n = 3, k = 1
//    Output: "0"
//    Explanation: S3 is "0111001".
//    The 1st bit is "0".
//    Example 2:
//    Input: n = 4, k = 11
//    Output: "1"
//    Explanation: S4 is "011100110110001".
//    The 11th bit is "1".
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
    }

    public static char findKthBit(int n, int k) {
        int len = (1 << n) - 1;  // length = 2^n - 1
        int mid = (len / 2) + 1; // midpoint
        if (n == 1){
            return '0';
        }
        if (k < mid){
            return findKthBit(n - 1, k);
        }
        else if (k == mid){
            return '1';
        }
        else{
            char ch = findKthBit(n - 1, len - (k - 1));
            if (ch == '0'){
                return '1';
            } else {
                return '0';
            }
        }
    }
}
