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
            new DisplayBook(),
                new BorrowBook(),
                new ReturnBook(),
                new ExitSystem()
        };
    }

    @Override
    public int menu() {
        return 0;
    }
}
