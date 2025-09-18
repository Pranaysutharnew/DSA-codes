package Recursion.Medium;

public class Leetcode_486 {
//    Input: nums = [1,5,2]
//    Output: false
//    Explanation: Initially, player 1 can choose between 1 and 2.
//    If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5,
//    then player 1 will be left with 1 (or 2).
//    So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
//    Hence, player 1 will never be the winner and you need to return false.
//    Example 2:
//
//    Input: nums = [1,5,233,7]
//    Output: true
//    Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7.
//    No matter which number player 2 choose, player 1 can choose 233.
//    Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        System.out.println(predictTheWinner(nums));
    }

    static Integer[][] dp = new Integer[23][23];
    public static boolean predictTheWinner(int[] nums) {
//        Arrays.fill(dp, 0);
        int len = nums.length;
        int total_score = 0;
        for (int i : nums){
            total_score += i;
        }
        int player1_score = helper(nums, 0, len -1);
        int player2_score = total_score - player1_score;

        return player1_score >= player2_score;
    }
    private static int helper(int[] nums, int left, int right){
        if (left > right){
            return 0;
        }
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        if (left == right){
            return nums[left];
        }

        int i = nums[left] + Math.min(helper(nums, left + 2, right), helper(nums, left + 1, right - 1));
        int j = nums[right] + Math.min(helper(nums, left, right - 2), helper(nums, left + 1, right - 1));
        int ans = Math.max(i, j);
        dp[left][right] = ans;
        return ans;
    }
}
