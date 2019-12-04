package user;

import book.Book;
import operation.Operation;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author DELL
 * @Date 2019/12/3 16:56
 **/
public abstract class AbstractUser {
    public String name;
    Operation [] operation;
    Scanner scanner =new Scanner(System.in);
    /**
     * 菜单
     * @return
     */
    public abstract int menu();
    public void doOperation(int choice, Book book){
        try {
            operation[choice].work(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
