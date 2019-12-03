package user;

import operation.*;

/**
 * @author DELL
 * @Date 2019/12/3 16:22
 **/
public class Admin extends AbstractUser{
    public Admin(String name) {
        this.name=name;
        this.operation = new Operation[]{
                new AddBook(),
                new DeleBook(),
                new AlterBook(),
                new DisplayBook(),
                new ExitSystem()
        };
    }
    @Override
    public int menu() {
        return 0;
    }
}
