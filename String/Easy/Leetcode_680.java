package String;

public class Leetcode_680 {
//    Input: s = "aba"
//    Output: true
//    Example 2:
//    Input: s = "abca"
//    Output: true
//    Explanation: You could delete the character 'c'.
//    Example 3:
//    Input: s = "abc"
//    Output: false
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                return isPali(s, left + 1, right) || isPali(s,left, right - 1);
            }
        }
        return true;
    }

    private static boolean isPali(String s, int left, int right) {
        while(left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else{
                return false;
            }
        }
        return true;
    }
}
