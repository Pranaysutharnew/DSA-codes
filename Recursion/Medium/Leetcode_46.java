package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_46 {
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//    Example 2:
//
//    Input: nums = [0,1]
//    Output: [[0,1],[1,0]]
//    Example 3:
//
//    Input: nums = [1]
//    Output: [[1]]
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    static int len;
    public static List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isVisited = new boolean[len + 1];
        perMutation(nums,new ArrayList<>() ,res, isVisited);
        return res;
    }

    private static void perMutation(int[] nums,List<Integer> list,List<List<Integer>> res, boolean[] isVisited) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));  // add one ans
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.add(nums[i]);

                perMutation(nums, list, res, isVisited);

                list.remove(list.size() - 1); // backtrack
                isVisited[i] = false;
            }
        }
    }
}
