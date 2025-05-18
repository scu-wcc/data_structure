package simple_problem;

public class topic21 {

    /*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 */

    /*public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }


        ArrayList<ListNode> arrayList=new ArrayList<>();

        while((list1!=null) ||(list2!=null) ){
            if(list1!=null){
                arrayList.add(list1);
                list1=list1.next;
            }
            if(list2!=null){
                arrayList.add(list2);
                list2=list2.next;
            }
        }
        Collections.sort(arrayList, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < arrayList.size(); i++) {
            if(i!=arrayList.size()-1){
                arrayList.get(i).next=arrayList.get(i+1);
            }else {
                arrayList.get(i).next=null;
            }

        }

        return arrayList.get(0);
    }*/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null || list2==null){
            return list1==null?list2:list1;
        }

        ListNode headNode= new ListNode();
        ListNode nextNode; //控制新链表的next指向节点
        nextNode=headNode;

        while (list1!=null && list2!=null){
            if(list1.val<= list2.val){
                nextNode.next=list1;
                nextNode = nextNode.next;
                list1 = list1.next;
            }else {
                nextNode.next=list2;
                nextNode = nextNode.next;
                list2 = list2.next;
            }
        }

        if(list1!=null){
            nextNode.next=list1;
        }else {
            nextNode.next=list2;
        }


        return headNode.next;
    }
}


