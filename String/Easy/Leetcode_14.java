//package String;
//
//public class Leetcode_14 {
////    Input: strs = ["flower","flow","flight"]
////    Output: "fl"
////    Example 2:
////    Input: strs = ["dog","racecar","car"]
////    Output: ""
////    Explanation: There is no common prefix among the input strings.
//    public static void main(String[] args) {
//        String[] str = {"flower","flow","flight"};
//        System.out.println(longestCommonPrefix(str));
//    }

//    public static String longestCommonPrefix(String[] strs) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < strs[0].length; i++) {
//            char ch = strs[0]
//        }
//    }

//    class Solution {
//        public String longestCommonPrefix(String[] strs) {
//            if (strs == null || strs.length == 0) return "";
//
//            String prefix = strs[0];
//
//            for (int i = 1; i < strs.length; i++) {
//                while (strs[i].indexOf(prefix) != 0) {
//                    prefix = prefix.substring(0, prefix.length() - 1);
//                    if (prefix.isEmpty()) return "";
//                }
//            }
//
//            return prefix;
//        }
//    }

//}
