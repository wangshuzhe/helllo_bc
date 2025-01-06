package demo;

public class Array136 {
    public static void main(String[] args) {

        int [] nums = {4,1,2,1,2};
        int i = singleNumber(nums);
        System.out.println(i);
    }
    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int j : nums) {
            num = num ^ j;
        }
        return num;
    }
}
