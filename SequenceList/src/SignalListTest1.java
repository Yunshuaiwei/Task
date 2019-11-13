import com.sun.istack.internal.XMLStreamException2;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.awt.geom.Line2D;

/**
 * @ProjectName Task
 * @ClassName SignalListTest1
 * Description
 * @Auther YunSW
 * @Date 2019/11/11 14:31
 * @Version 1.0
 **/
public class SignalListTest1 {
    public static void main(String[] args) {
        MySignalList2 list2 = new MySignalList2();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);
        list2.remove(5);
        list2.display();
    }
    //合并两个有序单链表
    public static ListNode2 mergeTwoLists(ListNode2 headA,ListNode2 headB){
        ListNode2 node=new ListNode2(-1);
        ListNode2 tmp=node;
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
    //两个单链表的交点
    public static ListNode2 getIntersectionNode(ListNode2 headA,ListNode2 headB){
        if(headA==null||headB==null){
            return null;
        }
        ListNode2 pL=headA;
        ListNode2 pS=headB;
        int lenA=0;
        ListNode2 tmp1=pL;
        while(tmp1!=null){
            lenA++;
            tmp1=tmp1.next;
        }
        int lenB=0;
        ListNode2 tmp2=pS;

        while(tmp2!=null){
            lenB++;
            tmp2=tmp2.next;
        }

        int len=lenA-lenB;
        if(len<0){
            pL=headB;
            pS=headA;
            len=lenB-lenA;
        }
        while(len>0){
            pL=pL.next;
            len--;
        }
        while(pL!=pS&&pS!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pS!=null){
            return pL;
        }
        return null;
    }
}
class ListNode2{
    public int data;
    public ListNode2 next;
    public ListNode2(int data){
        this.data=data;
        this.next=null;
    }
}
class MySignalList2 {
    public ListNode2 head;

    public MySignalList2() {
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode2 node= new ListNode2(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=head;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode2 node= new ListNode2(data);
        ListNode2 cur=this.head;
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
        ListNode2 cur=this.head;
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
        ListNode2 cur=this.head;
        while(cur.next!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    //打印
    public void display(){
        ListNode2 cur=this.head;
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
    //删除第一次出现关键字key
    public void remove(int key){
        if(this.head==null){
            return ;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        ListNode2 prev=searchPrev(key);
        if(prev==null){
            return;
        }else{
            prev.next=prev.next.next;
        }
    }

    private ListNode2 searchPrev(int key) {
        ListNode2 cur=this.head;
        while(cur!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode2 prev=this.head.next;
        ListNode2 cur=prev.next;
        if(this.head==null){
            return;
        }
        while(cur!=null){
            if(prev.next.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    //反转单链表
    public ListNode2 reverseList(){
        ListNode2 cur=this.head;
        ListNode2 prev=null;
        ListNode2 newHead=null;
        while(cur!=null){
            ListNode2 curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=prev.next;
            cur=curNext;
        }
        return newHead;
    }
    //返回中间元素
    public ListNode2 middleNode(){
        ListNode2 fast=this.head;
        ListNode2 slow=this.head;
        if(slow.next==null){
            return this.head;
        }
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //找倒数第k个节点
    public ListNode2 findKithTotail(int k){
        if(k<0){
            return null;
        }
        ListNode2 fast=this.head;
        ListNode2 slow=this.head;
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //将链表分为大于x和小于x两部分，并且不改变以前的顺序
    public ListNode2 partion(int x){
        ListNode2 cur=this.head;
        ListNode2 beforeStart=null;
        ListNode2 beforeEnd=null;
        ListNode2 afterStart=null;
        ListNode2 afterEnd=null;
        while(cur!=null){
            if(cur.data<x){
                if(beforeStart==null){
                    beforeStart=cur;
                    beforeEnd=cur;
                }else{
                    beforeEnd.next=cur;
                    beforeEnd=beforeEnd.next;
                }
            }else{
                if(afterStart==null){
                    afterStart=cur;
                    afterEnd=cur;
                }else{
                    afterEnd.next=cur;
                    afterEnd=afterEnd.next;
                }
            }
            cur=cur.next;
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
    //删除重复节点
    public ListNode2 daleteDuplication(){
        ListNode2 cur=this.head;
        ListNode2 node=new ListNode2(-1);
        ListNode2 tmp=node;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                tmp.next=cur;
                cur=cur.next;
                tmp=tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }
    //回文
    public boolean chkPalindrome(){
        ListNode2 fast=this.head;
        ListNode2 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode2 p=slow.next;
        while(p!=null){
            ListNode2 pNext=p.next;
            p.next=slow;
            slow=p;
            p=pNext;
        }
        while(this.head!=slow){
            if(this.head.data==slow.data){
                this.head=this.head.next;
                slow=slow.next;
                if(this.head.next==slow&&this.head.data==slow.data){
                    return true;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    //判断单链表是否有环
    public boolean hasCycle(){
        ListNode2 fast=this.head;
        ListNode2 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //环的入口
    public ListNode2 datectCycle(){
        ListNode2 fast=this.head;
        ListNode2 slow=this.head;
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
        while (fast!=null&&fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}