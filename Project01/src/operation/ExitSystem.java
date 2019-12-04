package operation;

import book.Book;

/**
 * @author DELL
 * @Date 2019/12/3 16:21
 **/
public class ExitSystem implements Operation{
    @Override
    public void work(Book book) {
        System.out.println("欢迎下次登录！");
        System.exit(0);
    }
}
