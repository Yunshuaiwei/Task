package operation;

import book.Book;
import com.sun.media.sound.SoftTuning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author DELL
 * @Date 2019/12/3 16:21
 **/
public class AlterBook implements Operation {

    @Override
    public void work(Book book) throws SQLException {
        System.out.println("请输入书名：");
        String name = scanner.nextLine();
        if(!book.hasBook(name)){
            System.out.println("没有此书！");
        }else{
            Connection conn = JDBCUtils.getConnection();
            String sql="select name,author,price,type,isBorrow from book where name=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,name);
            ResultSet rs = pre.executeQuery();
            Book book1 =null;
            String isBorrow =null;
            String name1 =null;
            if(rs.next()){
                name1 = rs.getString("name");
                String author = rs.getString("author");
                Double price = rs.getDouble("price");
                String type = rs.getString("type");
                isBorrow = rs.getString("isBorrow");
                book1 = new Book(name1, author, price, type);
            }
            System.out.println("请输入需要修改的属性：");
            String a=scanner.nextLine();
            System.out.println("请输入新的值：");
            if("书名".equals(a)){
                book1.name=scanner.nextLine();
            }else if("作者".equals(a)){
                book1.author=scanner.nextLine();
            }else if("价格".equals(a)){
                book1.price=scanner.nextDouble();
            }else{
                book1.type=scanner.nextLine();
            }
            String sql1="delete from book where name=?";
            PreparedStatement p = conn.prepareStatement(sql1);
            p.setString(1,name1);
            p.execute();
            String sql2 = "insert into book(name,author,price,type,isBorrow)values(?,?,?,?,?)";
            PreparedStatement p2 = conn.prepareStatement(sql2);
            p2.setString(1,book1.name);
            p2.setString(2,book1.author);
            p2.setDouble(3,book1.price);
            p2.setString(4,book1.type);
            p2.setString(5,isBorrow);
            p2.execute();
            p2.close();
            p.close();
            conn.close();
            System.out.println("修改成功！");
        }
    }
}
