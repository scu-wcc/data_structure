package class04;

import java.util.Stack;

public class LinkCoding {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode palindromeHead = new ListNode(1, node2);
        //System.out.println("结果为: "+isPalindrome(palindromeHead));
        //System.out.println("结果为: "+isPalindromeLess(palindromeHead));
        System.out.println("结果为: "+isPalindromeNoSpace(palindromeHead));

        ListNode node8 = new ListNode(4);
        ListNode node7 = new ListNode(3, node8);
        ListNode node6 = new ListNode(2, node7);
        ListNode nonPalindromeHead = new ListNode(1, node6);
        //System.out.println("结果为: "+isPalindrome(nonPalindromeHead));
        //System.out.println("结果为: "+isPalindromeLess(nonPalindromeHead));
        System.out.println("结果为: "+isPalindromeNoSpace(nonPalindromeHead));
    }

    public static boolean isPalindrome(ListNode head){
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while (p!=null){
            int val = p.val;
            stack.push(val);
            p=p.next;
        }
        p=head;
        while (p!=null){
            int val1 = p.val;
            int val2 = stack.pop();
            if(val1!=val2){
                return false;
            }
            p = p.next;
        }
        return true;
    }

    //只使用1/2N栈空间
    public static boolean isPalindromeLess(ListNode head){
        if (head == null || head.next ==null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next==null){
            fast=fast.next.next;
            slow=slow.next;
        }

        //从s+1开始压入栈
        fast = slow.next;
        Stack<ListNode> stack = new Stack<>();
        while (fast!=null){
            stack.push(fast);
            fast = fast.next;
        }

        //将slow重置
        slow = head;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            if(node.val != slow.val){
                return false;
            }
            slow=slow.next;
        }

        return true;
    }

    public static boolean isPalindromeNoSpace(ListNode head){
        if (head == null || head.next ==null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        fast = slow.next;
        slow.next=null;
        slow = fast.next;

        //防止开头元素嵌套
        fast.next=null;
        while (slow!=null){
            ListNode temp = slow.next;
            slow.next=fast;
            fast = slow;
            slow = temp;
        }

        /*while (slow!=null){
            ListNode temp = new ListNode(slow.val);
            temp.next = node;
            node = temp;
            slow=slow.next;
            fast=fast.next;
        }*/

        slow = head;

        while (fast!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow =slow.next;
            fast=fast.next;
        }

        return true;
    }

}


