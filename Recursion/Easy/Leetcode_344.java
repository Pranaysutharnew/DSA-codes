package Recursion.Easy;

import java.util.Arrays;

public class Leetcode_344 {
//    Input: s = ["h","e","l","l","o"]
//    Output: ["o","l","l","e","h"]
//    Example 2:
//
//    Input: s = ["H","a","n","n","a","h"]
//    Output: ["h","a","n","n","a","H"]
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        reverseStr(s, 0, s.length - 1);
    }
    public static void reverseStr(char[] s, int left, int right){
        if(left >= right){
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverseStr(s, left + 1, right - 1);
    }
}
