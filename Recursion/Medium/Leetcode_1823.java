package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1823 {
//    Input: n = 5, k = 2
//    Output: 3
//    Explanation: Here are the steps of the game:
//            1) Start at friend 1.
//            2) Count 2 friends clockwise, which are friends 1 and 2.
//            3) Friend 2 leaves the circle. Next start is friend 3.
//            4) Count 2 friends clockwise, which are friends 3 and 4.
//            5) Friend 4 leaves the circle. Next start is friend 5.
//            6) Count 2 friends clockwise, which are friends 5 and 1.
//            7) Friend 1 leaves the circle. Next start is friend 3.
//            8) Count 2 friends clockwise, which are friends 3 and 5.
//            9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.
//    Example 2:
//
//    Input: n = 6, k = 5
//    Output: 1
//    Explanation: The friends leave in this order: 5, 4, 6, 2, 3. The winner is friend 1.
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num = 1; num <= n; num++) {
            list.add(num);
        }
        return findWinner(list, k, 0);
    }

    private static int findWinner(List<Integer> list, int k, int i) {
        if (list.size() == 1) {
            return list.get(0);
        }
        int removeIdx = (i + (k - 1)) % list.size();
        list.remove(removeIdx);
        return findWinner(list, k, removeIdx);
    }

//    public int findTheWinner(int n, int k) {
//        int ans = 0;
//        for(int i = 2; i <= n; i++){
//            ans = (ans + k) % i;
//        }
//        return ans + 1;  // one-based indexing
//    }

}
