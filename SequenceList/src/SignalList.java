import java.io.OutputStream;
import java.util.List;

/**
 * @ProjectName SequenceList
 * @ClassName SignalList
 * Description
 * @Auther YunSW
 * @Date 2019/10/29 18:47
 * @Version 1.0
 **/
public class SignalList {
    public static void main(String[] args) {
        MySignalList lis=new MySignalList();
        MySignalList lis2=new MySignalList();
        lis.addLast(1);
        lis.addLast(2);
        lis.addLast(3);
//        lis.addLast(3);
        lis.addLast(2);
        lis.addLast(1);
        lis.display();
        //链表lis2
        lis2.addLast(1);
        lis2.addLast(2);
        lis2.addLast(3);
//        lis.addLast(3);
        lis2.addLast(21);
        lis2.addLast(1);
        System.out.println("---------------------------------------");
//        lis.addIndex(1,14);
//        lis.removeAllKey(10);
//        lis.display();
//        lis.display2(lis.deleteDuplication());
//        lis.display2(lis.partition(4));
//        System.out.println(lis.chkPalindrome());
//        lis.creatCycle();
//        System.out.println(lis.hasCycle());
//        System.out.println(lis.detectCycle());
        intersect(lis.head,lis2.head);
        ListNode node = getIntersectionNode(lis.head, lis2.head);
        System.out.println(node.data);
    }

    public static ListNode  getIntersectionNode
            (ListNode headA,ListNode headB){
        if(headA == null || headB == null) {
            return null;
        }
        //永远指向最长的单链表
        ListNode pL = headA;
        //永远指向最短的单链表
        ListNode pS = headB;

        int lenA = 0;
        ListNode tmp1=pL;
        while(tmp1!=null){
            lenA++;
            tmp1=tmp1.next;
        }
        int lenB = 0;
        ListNode tmp2=pS;
        while(tmp2!=null){
            lenB++;
            tmp2=tmp2.next;
        }
        //分别求长度

        //求长度的差值
        int len = lenA-lenB;
        //如果是负数-》pL = headB;  pS = headA
        if(len<0){
            pL=headB;
            pS=headA;
            len=lenB-lenA;
        }
        //只需要让pL走len步就好了
        while(len>0){
            pL=pL.next;
            len--;
        }
        //走完len步之后  两个同时开始走
        //一直走 走到next值相同时 就是交点
        while(pL!=pS&&pS!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pS!=null){
            return pL;
        }
       /*while(pL.next!=pS.next){
            pL=pL.next;
            pS=pS.next;
        }*/
        //万一没有相交，并且两个单链表一样长
        //防止最后一个节点
        /*if(pL.next==pS.next&&pL.next!=null){
            return pL.next;
        }*/
        return null;
    }

    //将两个单链表相交
    public static void intersect(ListNode headA,ListNode headB){
        headA.next.next=headB.next.next.next;
    }

    //合并两个有序单链表
    public static ListNode mergeTwoLists(
            ListNode headA,ListNode headB) {
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
        while(headA!=null&&headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;
            }else{
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
        }
        if(headA!=null){
            tmp.next=headA;
        }
        if(headB!=null){
            tmp.next=headB;
        }
        return null;
    }
}
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
class MySignalList{
    public ListNode head;
    public MySignalList(){
        this.head=null;
    }
    private  ListNode searchIndex(int index){
        ListNode cur=this.head;
        int count=0;
        while(count<index-1){
            count++;
            cur=cur.next;
        }
//        while(cur.next!=null){
//            count++;
//            cur=cur.next;
//            if(count==index-1){
//                break;
//            }
        return cur;
    }

    //在任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if(index<0||index>getLength()){
            System.out.println("位置不合法！");
            return false;
        }
        if(index==0){
            addFirst(data);
            return true;
        }
        ListNode cur=searchIndex(index);
        ListNode node =new ListNode(data);
        node.next=cur.next;
        cur.next=node;
        return true;
    }
    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=head;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        ListNode cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //查找
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur.data!=key){
            cur=cur.next;
            if(cur.next==null){
                return false;
            }
        }
        return true;
    }
    //获得链表长度
    public int getLength(){
        int count=0;
        ListNode cur=this.head;
        while(cur.next!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    //打印
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.printf("%d\t",cur.data);
            cur=cur.next;
        }
        System.out.println();
    }
    public void display2(ListNode newHead){
        ListNode cur=newHead;
        while(cur!=null){
            System.out.printf("%d\t",cur.data);
            cur=cur.next;
        }
        System.out.println();
    }

    //删除第一次出现关键字为key的节点
    //key的前驱节点
    private ListNode searchPrev(int key){
        ListNode cur=this.head;
        while(cur.next.data!=key){
            cur=cur.next;
            if(cur.next==null){
                return null;
            }
        }
        return cur;
    }
    public void remove(int key){
        if(this.head==null){
            System.out.println("单链表为空！");
            return;
        }
        ListNode lis=searchPrev(key);
        if(lis==null){
            System.out.println("没有该元素！");
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        lis.next=lis.next.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev=this.head.next;
        ListNode cur=this.head;
        while(prev!=null){
            if(cur.next.data==key){
                cur.next=prev.next;
                prev=prev.next;
            }else{
                cur=prev;
                prev=prev.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    public ListNode reverseList(){
        ListNode prev=null;
        ListNode newHead=null;
        ListNode cur=this.head;
        while(cur!=null){
            ListNode nextNode=cur.next;
            if(nextNode==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=nextNode;
        }
        return newHead;
    }
    //单链表的中间节点
    public ListNode middleNode(){
        ListNode slow=this.head;
        ListNode fast=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    //找倒数第k个节点之后的节点
    public ListNode findKtjToTail(int k){
        //k>getLength()
        if(k<0){
            return null;
        }
        ListNode slow=this.head;
        ListNode fast=this.head;
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println("没有这个节点！");
            }
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
//    public ListNode reverseList2(){
//        ListNode prev =null;
//        ListNode newHead=null;
//        ListNode cur=this.head;
//        while(cur!=null){
//            ListNode nextNode=cur.next;
//            if(nextNode==null){
//                newHead=cur;
//            }
//            cur.next=prev;
//            prev=cur;
//            cur=nextNode;
//        }
//        return newHead;
//    }
    public ListNode findKtjToTail2(int k){
        ListNode fast=null;
        ListNode slow=null;
        if(k<0){
            return null;
        }
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println("没有这个节点！");
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //11月2日
    public ListNode partition(int x) {
        ListNode cur = this.head;
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (cur != null) {
            /*ListNode curNext=cur;
            cur.next=null;*/
            //cur.data < x
            if(cur.data < x) {
                //第一次插入
                if(beforeStart==null) {
                    beforeStart=cur;
                    beforeEnd=cur;
                }else {
                    beforeEnd.next=cur;
                    beforeEnd=beforeEnd.next;
                }
            }else {
                //第一次插入
                if(afterStart == null) {
                    afterStart=cur;
                    afterEnd=cur;
                }else {
                    afterEnd.next=cur;
                    afterEnd=afterEnd.next;
                }
            }
            cur=cur.next;
            //cur=curNext;
        }
        if(beforeStart==null){
            return afterStart;
        }
        beforeEnd.next=afterStart;
        if(afterStart!=null){
            afterEnd.next=null;
        }
        return beforeStart;
    }

    //删除重复的节点
    public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if(cur.next != null &&
                    cur.data == cur.next.data) {
                //1、循环
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                //2、退出循环 cur要多走一步
                cur=cur.next;
//                tmp.next=cur;
            }else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }

    //回文
    public boolean chkPalindrome() {
        ListNode fast = this.head;
        ListNode slow = this.head;

        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            //反转
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇
        while(this.head!=slow){
            if(this.head.data==slow.data){
                this.head=this.head.next;
                slow=slow.next;
                //偶数回文
                if(this.head.next==slow&&this.head.data==slow.data){
                    return true;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    //判断是否有环
    public boolean hasCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
//        while(true){
//            fast=fast.next.next;
//            slow=slow.next;
//            if(fast==slow){
//                return true;
//            }
//            if(fast==null||fast.next == null){
//                return false;
//            }
//        }
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    //创建一个环
    public void creatCycle(){
        ListNode cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
    }
    //环的入口
    public ListNode detectCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=this.head;
        while(fast!=null&&fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}