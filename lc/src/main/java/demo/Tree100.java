package demo;

import config.TreeNode;

public class Tree100 {
    public static void main(String[] args) {

        TreeNode rightChild = new TreeNode(2);
        TreeNode root = new TreeNode(1,null, rightChild);
        TreeNode leftChild2 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1,leftChild2,null);
        boolean sameTree = isSameTree(root, root2);
        System.out.println(sameTree);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return p.getVal() == q.getVal() &&isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
    }
}
