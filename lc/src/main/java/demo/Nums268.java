package demo;

import java.util.HashMap;
import java.util.Map;

public class Nums268 {
    public static void main(String[] args) {
        int [] nums = {0};
        int i = missingNumber(nums);
        System.out.println(i);
    }
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=i;
            sum2 += nums[i];
        }
        sum+=nums.length;
        return sum-sum2;
    }
}
