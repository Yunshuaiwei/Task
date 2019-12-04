package operation;

import book.Book;

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
    void work(Book book);
    Scanner scanner=new Scanner(System.in);
}
