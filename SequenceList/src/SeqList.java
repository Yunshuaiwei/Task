/**
 * @ProjectName SequenceList
 * @ClassName SeqList
 * Description
 * @Auther YunSW
 * @Date 2019/10/29 17:50
 * @Version 1.0
 **/
public class SeqList {
    public static void main(String[] args) {
        MyArrayList lis=new MyArrayList();
        lis.add(0,51);
        lis.add(1,30);
        lis.add(2,14);
        lis.add(3,81);
        lis.add(4,79);
        lis.add(5,90);
        lis.add(6,16);
        lis.display();
        System.out.println("--------------------------------");
        lis.remove(2);
        lis.display();
    }
}
class MyArrayList{
    public int usedSize;
    public  int [] elem;
    public final int LENGTH=10;
    MyArrayList(){
        this.usedSize=0;
        this.elem=new int[LENGTH];
    }
    //增加元素
    public void add(int pos,int data){
        if(pos<0|pos>elem.length){
            System.out.println("插入的位置不合法！");
        }
        if(usedSize==elem.length){
            int []tmp=new int[LENGTH*2];
            System.arraycopy(elem,0,tmp,0,usedSize);
            elem=tmp;
        }
        int tmp=usedSize;
        while(usedSize!=pos){
            elem[tmp+1]=elem[tmp];
        }
        elem[pos]=data;
        usedSize++;
        System.out.println("插入成功！");
    }
    //删除指定位置的元素
    public void remove(int pos){
        if(pos<0||pos>usedSize){
            System.out.println("位置不合法！");
        }
        while(usedSize!=pos){
            this.elem[pos]=this.elem[pos+1];
            pos++;
        }
        usedSize--;
    }
    //判断是否包含某个元素
    public boolean contains(int toFind){
        for (int i = 0; i <usedSize ; i++) {
            if(elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    //查找pos位置的元素
    public int getPos(int pos){
        if(pos<0||pos>usedSize){
            System.out.println("位置不合法！");
            return -1;
        }
        return this.elem[pos];
    }
    //给pos位置的元素设为value
    public boolean setPos(int pos,int value){
        if(pos<0||pos>usedSize){
            System.out.println("位置不合法！");
            return false;
        }
        this.elem[pos]=value;
        return true;
    }
    //查找某个元素对应位置
    public int search(int toFind){
        for (int i = 0; i <usedSize ; i++) {
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    //删除第一次出现的关键字key
    public void toRemove(int toRemove){
        if(usedSize==0){
            return;
        }
        int a=search(toRemove);
        for (int i = a; i <usedSize-1 ; i++) {
            this.elem[i]=this.elem[i+1];
        }
        this.usedSize--;
    }
    //获取顺序表长度
    public int size(){
        return usedSize;
    }
    //清空顺序表
    public void clear(){
        this.usedSize=0;
    }
    //打印顺序表
    public void display(){
        for (int i = 0; i <usedSize ; i++) {
            System.out.println(elem[i]);
        }
    }
    //排序
    public void sort(){
        boolean flag=true;
        for (int i = 0; i <usedSize ; i++) {
            for (int j = 0; j <usedSize-1-i ; j++) {
                if(this.elem[j]>this.elem[j+1]){
                    int tmp=this.elem[j];
                    this.elem[j]=this.elem[j+1];
                    this.elem[j+1]=tmp;
                    flag=false;
                }
            }
            if(flag){
                return;
            }
        }
    }
}
