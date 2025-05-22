package simple_problem;

public class topic234 {
    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     */

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        fast=slow.next;
        slow.next=null;
        slow = fast.next;
        fast.next=null;
        while (slow!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast= slow;
            slow=temp;
        }

        slow = head;

        while (fast!=null){
            if(fast.val!=slow.val){
                return false;
            }

            fast=fast.next;
            slow = slow.next;
        }

        return true;

    }

}
