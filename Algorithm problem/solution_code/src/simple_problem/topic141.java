package simple_problem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class topic141 {

    //判断是否为环形链表
/*    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode curNode = head;
        while (curNode!=null){
            if(set.contains(curNode)){
                return true;
            }
            set.add(curNode);
            curNode = curNode.next;
        }

        return false;
    }*/
    public boolean hasCycle(ListNode head){

        if(head==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if(fast.next==null||fast.next.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
            if(fast == slow){
                return true;
            }
        }
    }
}
