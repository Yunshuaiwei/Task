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
        int choice;
        System.out.println("1、展示图书");
        System.out.println("2、借阅图书");
        System.out.println("3、归还图书");
        System.out.println("0、退出");
        System.out.println("请输入你的选择：");
        while(true){
            choice = scanner.nextInt();
            if(choice>3||choice<0){
                System.out.println("您输入的操作有误，请重新输入：");
            }else{
                break;
            }
        }
        return choice;
    }
}
