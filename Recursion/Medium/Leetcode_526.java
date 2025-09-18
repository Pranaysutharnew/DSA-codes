package Recursion.Medium;

public class Leetcode_526 {
//    Input: n = 2
//    Output: 2
//    Explanation:
//    The first beautiful arrangement is [1,2]:
//            - perm[1] = 1 is divisible by i = 1
//            - perm[2] = 2 is divisible by i = 2
//    The second beautiful arrangement is [2,1]:
//            - perm[1] = 2 is divisible by i = 1
//            - i = 2 is divisible by perm[2] = 1
//    Example 2:
//
//    Input: n = 1
//    Output: 1
    public static void main(String[] args) {
        System.out.println(countArrangement(3));
    }
    static int count;

    public static int countArrangement(int n) {
        boolean[] isVisited = new boolean[n + 1];
        countArr(n, 1, isVisited);
        return count;
    }

    private static void countArr(int n, int i, boolean[] isVisited) {
        if (i > n) count++;
        for (int j = 1; j <= n; j++) {
            if (!isVisited[j] && (i % j == 0 || j % i == 0)){
                isVisited[i] = true;
                countArr(n, i + 1, isVisited);
                isVisited[i] = false;
            }
        }
    }
}
