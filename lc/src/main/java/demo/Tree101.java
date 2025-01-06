package demo;

import config.TreeNode;

public class Tree101 {
    public static void main(String[] args) {
        TreeNode lThree1 = new TreeNode(4);
        TreeNode rThree1 = new TreeNode(3);
        TreeNode lThree2 = new TreeNode(3);
        TreeNode rThree2 = new TreeNode(3);
        TreeNode lTwo = new TreeNode(2,lThree1, rThree1);
        TreeNode rTwo = new TreeNode(2, lThree2, lThree2);
        TreeNode root = new TreeNode(1, lTwo, rTwo);
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isSymmetric(root.getLeft(), root.getRight());
    }
    public static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (null == node1 && null == node2) {
            return true;
        } else if (null == node1 || null == node2 || node1.getVal() != node2.getVal()){
            return false;
        }
        return isSymmetric(node1.getLeft(), node2.getRight()) && isSymmetric(node1.getRight(), node2.getLeft());
    }

}
