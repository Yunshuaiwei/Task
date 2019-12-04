package operation;

import book.Book;
import com.sun.media.sound.SoftTuning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author DELL
 * @Date 2019/12/3 16:19
 **/
public class DeleBook implements Operation{
    @Override
    public void work(Book book) throws SQLException {
        System.out.println("请输入需要删除的书名：");
        String name = scanner.nextLine();
        boolean b = book.hasBook(name);
        if(!b){
            System.out.println("没有此书！");
        }else{
            Connection conn = JDBCUtils.getConnection();
            String sql="delete from book where name=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,name);
            pre.execute();
            System.out.println("删除成功！");
            JDBCUtils.closeResources(conn,pre);
        }
    }
}
