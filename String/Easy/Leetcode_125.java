package String;

public class Leetcode_125 {
//    Input: s = "A man, a plan, a canal: Panama"
//    Output: true
//    Explanation: "amanaplanacanalpanama" is a palindrome.
//            Example 2:
//    Input: s = "race a car"
//    Output: false
//    Explanation: "raceacar" is not a palindrome.
//    Example 3:
//    Input: s = " "
//    Output: true
//    Explanation: s is an empty string "" after removing non-alphanumeric characters.
//    Since an empty string reads the same forward and backward, it is a palindrome.
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            // skip non-alphanumeric chars on the left
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            // skip non-alphanumeric chars on the right
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            // compare valid characters
            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
