package operation;

import book.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author DELL
 * @Date 2019/12/3 16:20
 **/
public class ReturnBook implements Operation{
    @Override
    public void work(Book book) {
        System.out.println("请输入需要归还的书名：");
        String name = scanner.nextLine();
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement p =null;
        try {
            String sql="update book set isBorrow='否'where name=?";
            p = conn.prepareStatement(sql);
            p.setString(1,name);
            p.execute();
            System.out.println("归还成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn,p);
        }
    }
}
