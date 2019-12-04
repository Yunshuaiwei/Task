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
public class BorrowBook implements Operation{
    @Override
    public void work(Book book) {
        System.out.println("请输入需要借阅的书名：");
        String name = scanner.nextLine();
        boolean b = book.hasBook(name);
        if(!b){
            System.out.println("没有此书！");
            return;
        }else{
            Connection conn = JDBCUtils.getConnection();
            String sql="select isBorrow from book where name=?";
            PreparedStatement p =null;
            PreparedStatement pre =null;
            try {
                pre = conn.prepareStatement(sql);
                pre.setString(1,name);
                ResultSet rs = pre.executeQuery();
                String isBorrow =null;
                if(rs.next()){
                    isBorrow = rs.getString("isBorrow");
                }

                if("否".equals(isBorrow)){
                    String sql2="update book set isBorrow='是'where name=?";
                    p = conn.prepareStatement(sql2);
                    p.setString(1,name);
                    p.execute();
                    System.out.println("借书成功！");
                }else{
                    System.out.println("此书已被借出！");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.closeResources(conn,pre);
                try {
                    if(p!=null){
                        p.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
