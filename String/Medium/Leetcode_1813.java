package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_1813 {
//    Example 1:
//    Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
//    Output: true
//    Explanation:
//    sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".
//    Example 2:
//    Input: sentence1 = "of", sentence2 = "A lot of words
//    Output: false
//    Explanation:
//    No single sentence can be inserted inside one of the sentences to make it equal to the other.
//    Example 3:
//    Input: sentence1 = "Eating right now", sentence2 = "Eating"
//    Output: true
//    Explanation:
//    sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
    public static void main(String[] args) {
        String str1 = "My name is Haley";
        String str2 = "My Haley";
        System.out.println(areSentencesSimilar(str1, str2));
    }

    public static boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return areSentencesSimilar(s2, s1);
        }

        List<String> list1;
        List<String> list2;

        // Splitting strings by spaces
        list1 = Arrays.asList(s1.split(" "));
        list2 = Arrays.asList(s2.split(" "));

        int i = 0, j = list1.size() - 1; // s1 (list1)
        int k = 0, l = list2.size() - 1; // s2 (list2)

        // Check for matching prefix
        while (k < list2.size() && i < list1.size() && list2.get(k).equals(list1.get(i))) {
            k++;
            i++;
        }

        // Check for matching suffix
        while (l >= k && list2.get(l).equals(list1.get(j))) {
            j--;
            l--;
        }

        return l < k;
    }
}
