package operation;

import book.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author DELL
 * @Date 2019/12/3 16:19
 **/
public class AddBook implements Operation{
    @Override
    public void work(Book book)  {
        System.out.println("请输入书名：");
        String name = scanner.next();
        boolean b = book.hasBook(name);
        if (b) {
            System.out.println("此书已经存在！");
        } else {
            Connection conn = JDBCUtils.getConnection();
            System.out.println("请输入作者：");
            String author = scanner.next();
            System.out.println("请输入价格：");
            String price = scanner.next();
            System.out.println("请输入图书类型：");
            String type = scanner.next();
            String sql = "insert into book(name,author,price,type,isBorrow)values(?,?,?,?,?)";
            PreparedStatement pre = null;
            try {
                pre = conn.prepareStatement(sql);
                pre.setString(1, name);
                pre.setString(2, author);
                pre.setString(3, price);
                pre.setString(4, type);
                pre.setString(5, "否");
                pre.execute();
                System.out.println("添加成功！");
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                JDBCUtils.closeResources(conn,pre);
            }
        }
    }
}
