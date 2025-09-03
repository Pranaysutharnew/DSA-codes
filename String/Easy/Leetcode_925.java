package String;

public class Leetcode_925 {
//    Input: name = "alex", typed = "aaleex"
//    Output: true
//    Explanation: 'a' and 'e' in 'alex' were long pressed.
//    Example 2:
//    Input: name = "saeed", typed = "ssaaedd"
//    Output: false
//    Explanation: 'e' must have been pressed twice, but it was not in the typed output.
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < len1 && idx2 < len2){
            if (name.charAt(idx1) == typed.charAt(idx2)){
                idx1++;
                idx2++;
                continue;
            }
            if (idx1 > 0 && name.charAt(idx1 - 1) == typed.charAt(idx2)){
                idx2++;
            }
            else {
                return false;
            }
        }
        if (idx1 < len1){
            return false;
        }
        while (idx2 < len2){
            if (name.charAt(len1 - 1) != typed.charAt(idx2)){
                return false;
            }
            idx2++;
        }
        return true;
    }
}
