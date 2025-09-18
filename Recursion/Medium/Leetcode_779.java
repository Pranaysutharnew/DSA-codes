package Recursion.Medium;

public class Leetcode_779 {
//    Input: n = 1, k = 1
//    Output: 0
//    Explanation: row 1: 0
//    Example 2:
//    Input: n = 2, k = 1
//    Output: 0
//    Explanation:
//    row 1: 0
//    row 2: 01
//    Example 3:
//    Input: n = 2, k = 2
//    Output: 1
//    Explanation:
//    row 1: 0
//    row 2: 01
    public static void main(String[] args) {
        System.out.println(kthGrammar(1 , 1));
    }

    public static int kthGrammar(int n, int k) {
        int len = 1 << (n - 1);



        if (n == 1&& k == 1){
            return 0;
        }
        if (k <= len / 2){
            return kthGrammar(n - 1,k);
        } else {
            int temp = kthGrammar(n - 1, k - len / 2);
            return temp == 0? 1 : 0;
        }
    }
}
