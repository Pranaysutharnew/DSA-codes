public class Leetcode_1342 {
    public static void main(String[] args) {
        System.out.println("Ans is : " + numberOfSteps(14));// ans 6
    }
    public static int numberOfSteps(int num) {
        int ans = recr(num, 0);
        return ans;
    }
    public static int recr(int num, int ans){
        if (num == 0) {
            return ans;
        }
        if (num%2 == 0) {
            return recr(num/2, ans + 1);
        } else{
            return recr(num-1, ans + 1);
        }
    }
}
