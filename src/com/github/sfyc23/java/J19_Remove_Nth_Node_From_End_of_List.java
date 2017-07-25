package com.github.sfyc23.java;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description
 * <p>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class J19_Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l4.next = l5;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;

        printNode(l1);
        printNode(removeNthFromEnd(l5, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = head;
        int length = 0;
        while (first != null) {
            first = first.next;
            length++;
        }

        first = dummy;
        for (int i = 0; i < length - n; i++) {
            first = first.next;
        }
        first.next = first.next.next;

        return dummy.next;
    }




    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void printNode(ListNode head) {

        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();

    }
}