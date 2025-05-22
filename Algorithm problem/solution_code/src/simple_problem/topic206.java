package simple_problem;

import java.util.Stack;

public class topic206 {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */

    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
 /*       Stack<ListNode> stack = new Stack<>();

        sortListNode(stack,head);
        ListNode result=new ListNode();
        ListNode temp = result;
        while (!stack.isEmpty()){
            temp.next=stack.pop();
            temp = temp.next;
        }
        temp.next=null;
        return result.next;*/

        ListNode first= head;

        ListNode second = head.next;
        first.next=null;
        while (second!=null){
            ListNode temp = second.next;
            second.next=first;
            first=second;
            second=temp;
        }

        return first;
    }

    public void sortListNode(Stack<ListNode> stack, ListNode listNode){
        if(listNode==null){
            return;
        }
        stack.push(listNode);
        sortListNode(stack,listNode.next);
    }
}
