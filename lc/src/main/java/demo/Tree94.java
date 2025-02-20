package demo;


import config.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Tree94 {
    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(3);
        TreeNode rightChild = new TreeNode(2, leftChild, null);
        TreeNode root = new TreeNode(1, null, rightChild);
       /* TreeNode leftChild = new TreeNode(3);
        TreeNode rightChild = new TreeNode(2);
        TreeNode root = new TreeNode(1,leftChild, rightChild);*/
        List<Integer> list = inorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       if (root == null) {
           return list;
       }
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        if (left != null) {
            List<Integer> list1 = inorderTraversal(left);
            list.addAll(list1);
        }
        list.add(root.getVal());
        if (right != null) {
            List<Integer> list1 = inorderTraversal(right);
            list.addAll(list1);
        }
        return list;
    }
}
