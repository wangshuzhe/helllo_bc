package w050107;

import config.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test050107 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node.setLeft(node2);
        node.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        List<Integer> integers = BinaryTree.levelOrder(node);
        ArrayBinaryTree tree = new ArrayBinaryTree(integers);
        Integer left = tree.left(2);
        System.out.println(left);
    }
}
