package String;

public class Leetcode_1668 {
//    Input: sequence = "ababc", word = "ab"
//    Output: 2
//    Explanation: "abab" is a substring in "ababc".
//    Example 2:
//    Input: sequence = "ababc", word = "ba"
//    Output: 1
//    Explanation: "ba" is a substring in "ababc". "baba" is not a substring in "ababc".
//    Example 3:
//    Input: sequence = "ababc", word = "ac"
//    Output: 0
//    Explanation: "ac" is not a substring in "ababc".
    public static void main(String[] args) {
        System.out.println(maxRepeating("aaabaaaabaaabaaaab", "aaab"));
    }
    public static int maxRepeating(String sequence, String word) {
        int maxCount = 0;
        String repeated = word;

        while (sequence.contains(repeated)) {
            maxCount++;
            repeated += word;
        }

        return maxCount;
    }

}
