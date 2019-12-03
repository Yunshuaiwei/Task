package user;

import operation.*;

/**
 * @author DELL
 * @Date 2019/12/3 16:23
 **/
public class NormalUser extends AbstractUser{
    public NormalUser(String name){
        this.name=name;
        this.operation=new Operation[]{
                new ExitSystem(),
                new DisplayBook(),
                new BorrowBook(),
                new ReturnBook()
        };
    }

    @Override
    public int menu() {
        System.out.println("欢迎登陆图书管理系统"+"("+name+")");
        System.out.println("请输入你的选择：");
        int choice = scanner.nextInt();
        System.out.println("1、展示图书");
        System.out.println("2、借阅图书");
        System.out.println("3、归还图书");
        System.out.println("0、退出");
        return choice;
    }
}
