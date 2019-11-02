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
        lis.addLast(1);
        lis.addLast(2);
        lis.addLast(3);
        lis.addLast(3);
        lis.addLast(2);
        lis.addLast(1);
        lis.display();
        System.out.println("---------------------------------------");
//        lis.addIndex(1,14);
//        lis.removeAllKey(10);
//        lis.display();
//        lis.display2(lis.deleteDuplication());
//        lis.display2(lis.partition(4));
//        System.out.println(lis.chkPalindrome());
//        lis.creatCycle();
        System.out.println(lis.hasCycle());
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
}