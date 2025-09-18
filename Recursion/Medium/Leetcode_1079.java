package Recursion.Medium;

public class Leetcode_1079 {
//    Input: tiles = "AAB"
//    Output: 8
//    Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
//    Example 2:
//
//    Input: tiles = "AAABBC"
//    Output: 188
//    Example 3:
//
//    Input: tiles = "V"
//    Output: 1
    public static void main(String[] args) {
        String tile = "AAABBC";
        System.out.println(numTilePossibilities(tile));
    }
    static int len;
    public static int numTilePossibilities(String tiles) {
//        Set<String> set = new HashSet<>();
        len = tiles.length();
        int[] freq = new int[26];

        for (int i = 0; i < len; i++) {
            freq[tiles.charAt(i) - 'A']++;
        }
        int count = numPoss(freq);
        return count;
    }

    private static int numPoss(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
//            isVisited[i] = true;
            count++;
            freq[i]--;
            count += numPoss(freq);
//            isVisited[i] = false;
            freq[i]++;
        }
        return count;
    }
}
