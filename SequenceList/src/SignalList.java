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
        lis.addFirst(20);
        lis.addFirst(13);
        lis.addFirst(10);
        lis.addLast(42);
        lis.addLast(50);
        lis.addLast(29);
        lis.display();

        System.out.println("---------------------------------------");
        lis.addIndex(1,14);
        lis.display();
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
        while(cur.next!=null){
            System.out.printf("%d\t",cur.data);
            cur=cur.next;
        }
        System.out.print(cur.data);
        System.out.println();
    }
}