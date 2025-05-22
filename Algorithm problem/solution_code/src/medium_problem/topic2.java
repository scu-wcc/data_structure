package medium_problem;

import java.math.BigDecimal;

public class topic2 {
    /*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。*/
 /*   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String str1="";
        while (l1!=null){
            str1=l1.val+str1;
            l1=l1.next;
        }

        String str2="";
        while (l2!=null){
            str2=l2.val+str2;
            l2=l2.next;
        }

        //System.out.println(str1+", "+str2);
        BigDecimal b1 = new BigDecimal(str1);
        BigDecimal b2 = new BigDecimal(str2);
        String sum = b1.add(b2).toString();
        //System.out.println(sum);

        ListNode headNode = new ListNode();
        ListNode tempNode=headNode;
        for (int i = sum.length()-1; i >=0 ; i--) {
            tempNode.val=Integer.parseInt(sum.charAt(i)+"");
            if(i==0){
                continue;
            }
            tempNode.next=new ListNode();
            tempNode=tempNode.next;
        }

        return headNode;
    }*/

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode headNode = new  ListNode();
        ListNode tempNode=headNode;
        int cur=0;
        int right;
        int left;

        while (l1!=null || l2!=null){
            left = l1!=null?l1.val:0;
            right = l2!=null?l2.val:0;

            tempNode.next=new ListNode((left+right+cur)%10);
            tempNode=tempNode.next;

            cur=(left+right+cur)/10;

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        if(cur>0) {
            tempNode.next=new ListNode(cur);
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode l1;
        ListNode listNode1= new ListNode(1);
        l1=listNode1;
        listNode1.next=new ListNode(2);
        listNode1=listNode1.next;
        listNode1.next=new ListNode(3);

        ListNode l2;
        ListNode listNode2= new ListNode(4);
        l2=listNode2;
        listNode2.next=new ListNode(5);
        listNode2=listNode2.next;
        listNode2.next=new ListNode(6);

        ListNode listNode = addTwoNumbers(l1, l2);
        while ((listNode!=null)){
            System.out.println(listNode.val);
            listNode=  listNode.next;
        }
    }

}


