package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_40 {
//    Input: candidates = [10,1,2,7,6,1,5], target = 8
//    Output:
//            [
//            [1,1,6],
//            [1,2,5],
//            [1,7],
//            [2,6]
//            ]
//    Example 2:
//
//    Input: candidates = [2,5,2,1,2], target = 5
//    Output:
//            [
//            [1,2,2],
//            [5]
//            ]
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
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

        for (int i = idx; i < candidates.length; i++){
            if (i > idx && candidates[i] == candidates[i - 1]){
                continue;
            }
            ls.add(candidates[i]);
            combi(candidates, target - candidates[i], list, ls, i + 1);
            ls.remove(ls.size() - 1);  // backtracing
        }
    }
}
