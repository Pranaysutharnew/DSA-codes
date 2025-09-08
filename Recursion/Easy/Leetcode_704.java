package Recursion.Easy;

public class Leetcode_704 {
//    Input: nums = [-1,0,3,5,9,12], target = 9
//    Output: 4
//    Explanation: 9 exists in nums and its index is 4
//    Example 2:
//
//    Input: nums = [-1,0,3,5,9,12], target = 2
//    Output: -1
//    Explanation: 2 does not exist in nums so return -1
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
