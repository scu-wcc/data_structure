力扣算法启示：

1.对于全局常量对象，通过static final和静态初始化代码块来初始化可以：
	
	1.对象随着类的加载而加载，地址唯一，所有类对象共享，节省空间。
	2.无法被修改，安全性更高。
	3.随着类加载而加载(类加载时执行初始化)，避免了重复初始化，性能更优。
	4.符合 Java 最佳实践：将常量数据声明为 static final。
	
2. 相交链表巧妙解法
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

3.摩尔投票
	“同归于尽消杀法” ：

	由于多数超过50%, 比如100个数，那么多数至少51个，剩下少数是49个。
	第一个到来的士兵，直接插上自己阵营的旗帜占领这块高地，此时领主 winner 就是这个阵营的人，现存兵力 count = 1。
	如果新来的士兵和前一个士兵是同一阵营，则集合起来占领高地，领主不变，winner 依然是当前这个士兵所属阵营，现存兵力 count++；
	如果新来到的士兵不是同一阵营，则前方阵营派一个士兵和它同归于尽。 此时前方阵营兵力count --。
	（即使双方都死光，这块高地的旗帜 winner 依然不变，因为已经没有活着的士兵可以去换上自己的新旗帜）
	当下一个士兵到来，发现前方阵营已经没有兵力，新士兵就成了领主，winner 变成这个士兵所属阵营的旗帜，现存兵力 count ++。
	就这样各路军阀一直以这种以一敌一同归于尽的方式厮杀下去，直到少数阵营都死光，那么最后剩下的几个必然属于多数阵营，winner 就是多数阵营。
	（多数阵营 51个，少数阵营只有49个，死剩下的2个就是多数阵营的人）
	
	
	