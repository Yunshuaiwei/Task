package operation;

import book.Book;

import java.sql.*;

/**
 * @author DELL
 * @Date 2019/12/3 16:19
 **/
public class DisplayBook implements Operation{
    @Override
    public void work(Book book) {
        int length=10;
        Book[] books =new Book[length];
        int i=0;
        PreparedStatement pre =null;
        Connection conn = JDBCUtils.getConnection();
        String sql="select name,author,price,type,isBorrow from book ";
        try {
            pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                String isBorrow = rs.getString("isBorrow");
                books[i]=new Book(name,author,price,type,isBorrow);
                i++;
                if(i==length){
                    length*=2;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn,pre);
        }
        for (Book b:books) {
            if(b==null){
                break;
            }else{
                System.out.println(b.toString());
            }
        }
    }
}
