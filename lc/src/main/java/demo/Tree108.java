package demo;

import config.TreeNode;

public class Tree108 {
    /*
    将递增数组转换为平衡二叉搜索树
     */
    public static void main(String[] args) {
        /*
        数组中间为根节点，数组左侧数据就是根节点的左侧树的子节点，数组右侧数据就是根节点的右子节点。
         */
        int[] nums = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length -1);
    }
    public static TreeNode helper(int [] nums, int left, int right) {
        //中值取完就返回 null
        if (left > right) {
            return null;
        }
        //取数组中值
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.setLeft(helper(nums, left, mid -1));
        root.setRight(helper(nums, mid + 1, right));
        return root;
    }
}
