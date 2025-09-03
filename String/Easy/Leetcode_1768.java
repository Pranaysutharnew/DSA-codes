package String;

public class Leetcode_1768 {
//    Input: word1 = "abc", word2 = "pqr"
//    Output: "apbqcr"
//    Explanation: The merged string will be merged as so:
//    word1:  a   b   c
//    word2:    p   q   r
//    merged: a p b q c r
//    Example 2:
//    Input: word1 = "ab", word2 = "pqrs"
//    Output: "apbqrs"
//    Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//            word1:  a   b
//    word2:    p   q   r   s
//    merged: a p b q   r   s
//    Example 3:
//    Input: word1 = "abcd", word2 = "pq"
//    Output: "apbqcd"
//    Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//            word1:  a   b   c   d
//    word2:    p   q
//    merged: a p b q c   d
    public static void main(String[] args) {
        System.out.println(mergeAlternately("apjxf", "pqr"));//appqjrxf
    }

    public static String mergeAlternately(String word1, String word2) {
        if (word1.length() < word2.length()) {
            return mergeAlternately(word2, word1);
        }

        int len1 = word1.length();
        int len2 = word2.length();
        int j = 0;
        int k = 0;
        StringBuilder sb = new StringBuilder();

        // Merge alternately for the length of the shorter word
        for (int i = 0; i < len2 * 2; i++) {
            if (i % 2 == 0) {
                sb.append(word1.charAt(j));
                j++;
            } else {
                sb.append(word2.charAt(k));
                k++;
            }
        }

        // Append remaining characters from the longer word (word1)
        while (j < len1) {
            sb.append(word1.charAt(j));
            j++;
        }

        return sb.toString();
    }

}
