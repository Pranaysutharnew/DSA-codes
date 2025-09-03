package String;

public class Leetcode_2000 {
//    Input: word = "abcdefd", ch = "d"
//    Output: "dcbaefd"
//    Explanation: The first occurrence of "d" is at index 3.
//    Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
//    Example 2:
//
//    Input: word = "xyxzxe", ch = "z"
//    Output: "zxyxxe"
//    Explanation: The first and only occurrence of "z" is at index 3.
//    Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
//    Example 3:
//
//    Input: word = "abcd", ch = "z"
//    Output: "abcd"
//    Explanation: "z" does not exist in word.
//    You should not do any reverse operation, the resulting string is "abcd".
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'x'));
    }
    public static String reversePrefix(String word, char ch) {
        if (!word.contains(Character.toString(ch))) return word;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            sb.append(temp);
            if (flag && temp == ch){
                sb.reverse();
                flag = false;
            }
        }
        return sb.toString();
    }
}
