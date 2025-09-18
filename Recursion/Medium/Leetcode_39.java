package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_39 {
//    Input: candidates = [2,3,6,7], target = 7
//    Output: [[2,2,3],[7]]
//    Explanation:
//    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//    These are the only two combinations.
//    Example 2:
//    Input: candidates = [2,3,5], target = 8
//    Output: [[2,2,2,2],[2,3,3],[3,5]]
//    Example 3:
//    Input: candidates = [2], target = 1
//    Output: []
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combi(candidates, target,list, new ArrayList<>(), 0);
        return list;
    }

    private static void combi(int[] candidates, int target, List<List<Integer>> list,List<Integer> ls, int idx) {
        if (target < 0){
            return;
        }
        if (target == 0){
            list.add(new ArrayList<>(ls));
        }
        for (int i = idx; i < candidates.length; i++) {
            ls.add(candidates[i]);
            combi(candidates, target - candidates[i], list, ls, i);
            ls.removeLast();
        }
    }
}
