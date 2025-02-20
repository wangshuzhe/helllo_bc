package demo;

import config.TreeNode;

public class Tree104 {
    public static void main(String[] args) {
        TreeNode lFour1 = new TreeNode(4);
        TreeNode lThree1 = new TreeNode(3, lFour1, null);
        TreeNode rThree1 = new TreeNode(3);
        TreeNode lThree2 = new TreeNode(3);
        TreeNode rThree2 = new TreeNode(3);
        TreeNode lTwo = new TreeNode(2,lThree1, rThree1);
        TreeNode rTwo = new TreeNode(2, lThree2, rThree2);
        TreeNode root = new TreeNode(1, lTwo, rTwo);
        int i = maxDepth(root);
        System.out.println(i);
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());
        return Math.max(left, right) + 1;
    }
}
