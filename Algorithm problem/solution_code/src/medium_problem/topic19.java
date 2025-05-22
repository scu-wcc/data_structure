package medium_problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class topic19 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */

    public static void main(String[] args) {
        topic19 p = new topic19();
        ListNode head = new ListNode(3);
        ListNode temp = head;
        for (int i = 0; i < 1; i++) {
            temp.next=new ListNode(9+i);
            temp=temp.next;
        }
        p.removeNthFromEnd(head,2);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    /**
     *
     * 使用双指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }

        ListNode result = new ListNode();
        result.next = head;
        ListNode fast = result;
        ListNode slow = result;

        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }

        while (fast!=null){
            if(fast.next==null){
                slow.next = slow.next.next;
                break;
            }
            fast=fast.next;
            slow=slow.next;
        }

        return result.next;
    }


}
