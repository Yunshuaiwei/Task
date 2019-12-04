package user;

import com.sun.media.sound.SoftTuning;
import operation.*;

/**
 * @author DELL
 * @Date 2019/12/3 16:22
 **/
public class Admin extends AbstractUser{
    public Admin(String name) {
        this.name=name;
        this.operation = new Operation[]{
                new ExitSystem(),
                new AddBook(),
                new DeleBook(),
                new AlterBook(),
                new DisplayBook()
        };
    }
    @Override
    public int menu() {
        int choice;
        System.out.println("1、添加书籍");
        System.out.println("2、删除书籍");
        System.out.println("3、修改图书信息");
        System.out.println("4、展示所有图书");
        System.out.println("0、退出");
        System.out.println("请输入你的选择：");
        while(true){
            choice = scanner.nextInt();
            if(choice>4||choice<0){
                System.out.println("您输入的操作有误，请重新输入：");
            }else{
                break;
            }
        }
        return choice;
    }
}
