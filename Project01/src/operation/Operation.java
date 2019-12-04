package operation;

import book.Book;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author DELL
 */
public interface Operation {
    /**
     * 实现功能
     * @param book
     * @return
     */
    void work(Book book) throws SQLException;
    Scanner scanner=new Scanner(System.in);
}
