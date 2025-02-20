package w050107;

import config.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 树的三种构造方法
 */
public class BinaryTree {
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
        System.out.println(levelOrder(node));
        List<Integer> list = new ArrayList<>();
        preOrder(node, list);
        System.out.println(list);
        list.clear();
        inOrder(node, list);
        System.out.println(list);
        list.clear();
        postOrder(node, list);
        System.out.println(list);

    }

    /**
     * 层序遍历
     */
    static List<Integer> levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.getVal());
            if (poll.getLeft() != null) {
                queue.offer(poll.getLeft());
            }
            if (poll.getRight() != null)
                queue.offer(poll.getRight());
        }
        return list;
    }

    /**
     * 前序遍历
     */
    static void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.getVal());
        preOrder(node.getLeft(), list);
        preOrder(node.getRight(), list);
    }

    /**
     * 中序遍历
     */
    static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft(), list);
        list.add(node.getVal());
        inOrder(node.getRight(), list);
    }

    /**
     * 后序遍历
     */
    static void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft(), list);
        postOrder(node.getRight(), list);
        list.add(node.getVal());
    }
}
