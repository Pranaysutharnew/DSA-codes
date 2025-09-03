package String;

import com.sun.jdi.Value;

public class Leetcode_1528 {
//    Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
//    Output: "leetcode"
//    Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
//    Example 2:
//    Input: s = "abc", indices = [0,1,2]
//    Output: "abc"
//    Explanation: After shuffling, each character remains in its position.
    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }

    public static String restoreString(String s, int[] indices) {
        int len = s.length();
        char[] str = new char[len];
        for (int i = 0; i < len; i++) {
            str[indices[i]] = s.charAt(i);
        }
        return String.valueOf(str);
    }
}
