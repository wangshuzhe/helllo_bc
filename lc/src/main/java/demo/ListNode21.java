package demo;

import config.ListNode;

public class ListNode21 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(4);
        list1.setNext(list2);
        list2.setNext(list3);
        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        ListNode list6 = new ListNode(4);
        list4.setNext(list5);
        list5.setNext(list6);
        ListNode listNode = mergeTwoLists(list1, list4);
        while (listNode != null) {
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //设置一个虚拟头结点
        ListNode preHead = new ListNode(-1);
        //新创建一个头节点
        ListNode prev = preHead;
        //循环链表
        while (l1 != null && l2 != null) {
            //比较两个链表头节点，将较小的节点加入新链表
            if (l1.getVal() <= l2.getVal()) {
                prev.setNext(l1);
                //将小节点所在的链表往后往后迁移一位
                l1 = l1.getNext();
            } else {
                prev.setNext(l2);
                l2 = l2.getNext();
            }
            prev = prev.getNext();
        }
        //两个链表长度不同的话循环不完全,将剩余的链表直接加入新链表后面就行
        prev.setNext(l1 == null ? l2 : l1);
        return preHead.getNext();
    }
}
