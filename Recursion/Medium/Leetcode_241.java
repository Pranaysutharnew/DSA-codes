package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_241 {
//    Input: expression = "2-1-1"
//    Output: [0,2]
//    Explanation:
//            ((2-1)-1) = 0
//            (2-(1-1)) = 2
//    Example 2:
//
//    Input: expression = "2*3-4*5"
//    Output: [-34,-14,-10,-10,10]
//    Explanation:
//            (2*(3-(4*5))) = -34
//            ((2*3)-(4*5)) = -14
//            ((2*(3-4))*5) = -10
//            (2*((3-4)*5)) = -10
//            (((2*3)-4)*5) = 10
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        int len = expression.length();
        List<Integer>[][] dp = new ArrayList[len][len];
        return recursion(expression, 0, len - 1, dp);
    }

    private static List<Integer> recursion(String expression, int start, int end, List<Integer>[][] dp) {
        List<Integer> result = new ArrayList<>();
        if (dp[start][end] != null){
            return dp[start][end];
        }
        //single digits
        if (start == end){
            int num = expression.charAt(start) - '0';
            result.add(num);
            return result;
        }
        // two digits
        if (end - start == 1 && Character.isDigit(expression.charAt(end))){
            int num = Integer.parseInt(expression.substring(start, end + 1));
            result.add(num);
            return result;
        }

        for (int i = start; i <= end; i++){
            if (Character.isDigit(expression.charAt(i))){
                continue;
            }
            char op = expression.charAt(i);
            List<Integer> left = recursion(expression, start, i - 1, dp);
            List<Integer> right = recursion(expression, i + 1, end, dp);
            for (int l : left){
                for (int r : right){
                    if (op == '*'){
                        result.add(l * r);
                    } else if (op == '-') {
                        result.add(l - r);
                    } else {
                        result.add(l + r);
                    }
                }
            }
        }
        dp[start][end] = result;
        return result;
    }
}
