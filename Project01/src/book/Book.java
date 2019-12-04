package book;

import operation.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author DELL
 * @Date 2019/12/3 16:13
 **/
public class Book {
    String name;
    String author;
    double price;
    String type;
    String isBorrow;
    public Book(String name, String author, double price, String type,String isBorrow) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        this.isBorrow=isBorrow;
    }
    public Book(){}


    /**
     * 判断是否有此书
     * @param name
     * @return
     * @throws SQLException
     */
    public boolean hasBook(String name)  {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement pre =null;
        String sql="select name,author,price,type,isBorrow from book where name=?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1,name);
            ResultSet rs = pre.executeQuery();
            if(!rs.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn,pre);
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" +
                "书名：'" + name + '\'' +
                ", 作者：'" + author + '\'' +
                ", 价格：" + price +
                ", 类型：'" + type + '\'' +
                ", 借出：'" + isBorrow + '\'' +
                ']';
    }
}
