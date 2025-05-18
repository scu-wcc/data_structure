package simple_problem;

public class topic160 {
/*    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tempA=headA;

        while (tempA!=null){
            ListNode tempB=headB;
            while (tempB!=null){
                if(tempA==tempB){
                    return tempA;
                }
                tempB=tempB.next;
            }
            tempA=tempA.next;
        }

        return null;
    }*/

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        int lenA=0;
//        int lenB=0;
//        ListNode pA=headA;
//        ListNode pB=headB;
//
//        while (pA!=null){
//            lenA++;
//            pA=pA.next;
//        }
//        while (pB!=null){
//            lenB++;
//            pB=pB.next;
//        }
//
//        pA=headA;
//        pB=headB;
//        if(lenA>lenB){
//            int step = lenA-lenB;
//            for (int i = 0; i < step; i++) {
//                pA=pA.next;
//            }
//            for (int i = 0; i < lenB; i++) {
//                if (pA==pB){
//                    return pA;
//                }
//                pA=pA.next;
//                pB=pB.next;
//            }
//        }else {
//            int step = lenB-lenA;
//            for (int i = 0; i < step; i++) {
//                pB=pB.next;
//            }
//            for (int i = 0; i < lenA; i++) {
//                if (pA==pB){
//                    return pA;
//                }
//                pA=pA.next;
//                pB=pB.next;
//            }
//        }
//        return null;
//    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA!=pB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }

        return pA;
    }

}

