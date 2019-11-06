import org.junit.jupiter.api.Test;

import java.io.*;

import static java.lang.System.*;

/**
 * @ProjectName Task
 * @ClassName IOTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/6 12:16
 * @Version 1.0
 **/
public class IOTest {
    public static void main(String[] args) {
        test3();
    }
    @Test
    public void test1(){
        File file1=new File("hello");
        BufferedReader bfr= null;
        BufferedWriter bfw= null;
        try {
            FileReader fr=new FileReader(file1);
            FileWriter fw=new FileWriter("hello2");
            bfr = new BufferedReader(fr);
            bfw = new BufferedWriter(fw);
            char [] buff=new char[5];
            int len;
            while((len=bfr.read(buff))!=-1){
                bfw.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bfr!=null){
                    bfr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bfw!=null){
                    bfw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    @Test
    public void test2() {
        BufferedInputStream bfis= null;
        BufferedOutputStream bfos= null;
        try {
            bfis = new BufferedInputStream(new FileInputStream(new File("11.jpg")));
            bfos = new BufferedOutputStream(new FileOutputStream("12.jpg"));
            byte [] buff=new byte[1024];
            int len;
            while((len=bfis.read(buff))!=-1){
                bfos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bfis!=null){
                    bfis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bfos!=null){
                    bfos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public static void test3() {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader buff= null;
        try {
            buff = new BufferedReader(isr);
            int tmp=5;
            while(tmp>0){
                System.out.println("请输入密码：");
                String data=buff.readLine();
                if(data.equals("123456")){
                    System.out.println("恭喜你进入游戏！");
                    System.exit(0);
                }else{
                    tmp--;
                    System.out.println("密码错误，请重新输入！" +tmp+"次机会！");
                }
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(buff!=null){
                    buff.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
