package whiles.test1;

import config.ListNode;

public class ListNodeTest {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node.setNext(node1);
        node1.setNext(node2);
        insert(node1, node3);
        while (node != null) {
            System.out.println(node.getVal());
            node = node.getNext();
        }

    }

    static void insert(ListNode node, ListNode insertNode) {
        ListNode next = node.getNext();
        insertNode.setNext(next);
        node.setNext(insertNode);
    }
}
