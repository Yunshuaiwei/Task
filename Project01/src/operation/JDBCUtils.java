package operation;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author DELL
 * @Date 2019/12/3 16:22
 **/
public class JDBCUtils {
    public static Connection getConnection() {
        Connection conn = null;
        FileInputStream fis =null;
        try {
            fis = new FileInputStream("Project01/jdbc.properties");
            Properties ps = new Properties();
            ps.load(fis);
            String user = ps.getProperty("user");
            String password = ps.getProperty("password");
            String url = ps.getProperty("url");
            String driver = ps.getProperty("driver");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return conn;
    }
    public static void closeResources(Connection conn, PreparedStatement ps) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
