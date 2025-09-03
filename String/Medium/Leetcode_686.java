package String;

public class Leetcode_686 {
//    Input: a = "abcd", b = "cdabcdab"
//    Output: 3
//    Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
//    Example 2:
//
//    Input: a = "a", b = "aa"
//    Output: 2
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
//        System.out.println(repeatedStringMatch("a", "aa"));

    }

    public static int repeatedStringMatch(String a, String b) {
        StringBuilder temp = new StringBuilder(a);
        int count = 1;

        while (temp.length() < b.length()) {
            temp.append(a);
            count++;
        }

        if (temp.toString().contains(b)) return count;

        temp.append(a);
        count++;
        if (temp.toString().contains(b)) return count;

        return -1;
    }
}
