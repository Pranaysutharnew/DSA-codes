package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_216 {
//    Input: k = 3, n = 7
//    Output: [[1,2,4]]
//    Explanation:
//            1 + 2 + 4 = 7
//    There are no other valid combinations.
//    Example 2:
//
//    Input: k = 3, n = 9
//    Output: [[1,2,6],[1,3,5],[2,3,4]]
//    Explanation:
//            1 + 2 + 6 = 9
//            1 + 3 + 5 = 9
//            2 + 3 + 4 = 9
//    There are no other valid combinations.
//    Example 3:
//
//    Input: k = 4, n = 1
//    Output: []
//    Explanation: There are no valid combinations.
//            Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10
//    and since 10 > 1, there are no valid combination.
    public static void main(String[] args) {
        System.out.println(combinationSum3(4, 1));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>(k);
        int[] candidates = new int[9];
        for (int i = 1; i <= 9; i++) {
            candidates[i - 1]= i;
        }
//        Arrays.sort(candidates);
        combi(candidates, n,list, new ArrayList<>(), 0, k);
        return list;
    }

    private static void combi(int[] candidates, int target, List<List<Integer>> list,List<Integer> ls, int idx, int k) {
        if (target < 0){
            return;
        }
        if (target == 0 && ls.size() == k) {
            list.add(new ArrayList<>(ls));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) break; // pruning
            ls.add(candidates[i]);
            combi(candidates, target - candidates[i], list, ls, i + 1, k);
            ls.remove(ls.size() - 1); // backtrack
        }
    }
}
