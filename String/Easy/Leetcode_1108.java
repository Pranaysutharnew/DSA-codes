package String;

public class Leetcode_1108 {
//    Input: address = "1.1.1.1"
//    Output: "1[.]1[.]1[.]1"
//    Example 2:
//
//    Input: address = "255.100.50.0"
//    Output: "255[.]100[.]50[.]0"
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);
            if (ch == '.'){
                sb.append("[.]");
            } else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
