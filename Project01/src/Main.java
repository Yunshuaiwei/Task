import com.sun.media.sound.SoftTuning;
import operation.JDBCUtils;
import user.Admin;
import user.NormalUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author DELL
 * @Date 2019/12/3 17:20
 **/
public class Main {

    public static void main(String[] args) {
        int choice = login();
        System.out.println(choice);
    }
    public static int login() {
        int choice;
        Connection conn = JDBCUtils.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("账户类型：0.普通用户<----->1.管理员");
        System.out.println("请选择账户类型：");
        while(true){
            choice= scanner.nextInt();
            if(choice==0){
                break;
            }else if(choice==1){
                break;
            }else{
                System.out.println("账户类型输入错误，请重新输入：");
            }
        }
        System.out.println("请输入账号：");
        String user=scanner.next();
        ResultSet rs =null;
        PreparedStatement ps = null;
        while(true){
            String sql="select id,password from user where id=?";
            try {
                ps = conn.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.setString(1,user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(!rs.next()){
                    System.out.println("账号错误，请重新输入：");
                    user=scanner.next();
                }else{
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("请输入密码：");
        String password=scanner.next();
        String pass=null;
        try {
            pass = rs.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while(!password.equals(pass)){
            System.out.println("密码错误，请重新输入：");
            password=scanner.next();
        }
        JDBCUtils.closeResources(conn,ps);
        scanner.close();
        System.out.println("登录成功！");
        return choice;
    }
}
