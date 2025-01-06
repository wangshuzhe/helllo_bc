package whiles.test1;

public class Test1 {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int num = 11;
        int index = 4;
//        insert(nums, num, index);
//        delete(nums, index);
        int[] extend = extend(nums, index);
        for (int i : extend) {
            System.out.println(i);
        }
    }

    static void insert(int[] nums, int num, int index) {
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;
    }

    static void delete(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length-1] = 0;
    }

    static int[] extend(int[] nums, int length) {
        int[] res = new int[nums.length + length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }
}
