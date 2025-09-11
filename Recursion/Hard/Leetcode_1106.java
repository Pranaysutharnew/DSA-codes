package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_1106 {
//    Input: expression = "&(|(f))"
//    Output: false
//    Explanation:
//    First, evaluate |(f) --> f. The expression is now "&(f)".
//    Then, evaluate &(f) --> f. The expression is now "f".
//    Finally, return false.
//    Example 2:
//
//    Input: expression = "|(f,f,f,t)"
//    Output: true
//    Explanation: The evaluation of (false OR false OR false OR true) is true.
//    Example 3:
//
//    Input: expression = "!(&(f,t))"
//    Output: true
//    Explanation:
//    First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
//    Then, evaluate !(f) --> NOT false --> true. We return true.
    public static void main(String[] args) {
        String str = "!(&(f,t))";
        System.out.println(parseBoolExpr(str));
    }

    public static boolean parseBoolExpr(String expression) {
        int len = expression.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++){
            char ch = expression.charAt(i);
            if (ch == ',') continue;
            if (ch == ')'){
                List<Character> values = new ArrayList<>();
                // Gather all values inside the parentheses
                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }
                stack.pop();
                char operetor = stack.pop();
                stack.push(solveExpression(operetor, values));
            } else {
               stack.push(ch);
            }
        }
        return stack.peek() == 't';
    }

    private static Character solveExpression(char op, List<Character> values) {
        if (op == '!'){
            return values.get(0) == 't' ? 'f' : 't';
        }

        if (op == '&'){
            for (char val : values) {
                if (val == 'f'){
                    return 'f';
                }
            }
            return 't';
        }
        if (op == '|'){
            for (char val : values){
                if (val == 't'){
                    return 't';
                }
            }
            return 'f';
        }
        return 't'; // this code will never reach at this point
    }
}
