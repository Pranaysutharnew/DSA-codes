package String;

public class Leetcode_1871 {
//    Input: s = "011010", minJump = 2, maxJump = 3
//    Output: true
//    Explanation:
//    In the first step, move from index 0 to index 3.
//    In the second step, move from index 3 to index 5.
//    Example 2:
//    Input: s = "01101110", minJump = 2, maxJump = 3
//    Output: false
    public static void main(String[] args) {
        System.out.println(canReach("011010", 2, 3));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        char[] ch = s.toCharArray();
        dp[0] = ch[0] == '0';
        int isReachble = 0;
        for(int i = 1; i < n; i++){
            if(i>= minJump){// we have to add here
                isReachble += dp[i - minJump]? 1 : 0;
            }
            if(i > maxJump){// we have to remove here
                isReachble -= dp[i - maxJump - 1]? 1 : 0;
            }
            dp[i] = isReachble > 0 && ch[i] == '0';
        }
        return dp[n - 1];
    }
}
