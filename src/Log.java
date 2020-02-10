import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author DELL
 * @Date 2019/12/9 16:29
 **/
public class Log {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(Log::creatLog);
    }
    public static void creatLog(){
        JFrame jf = new JFrame("登录");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500,300);
        jf.setLocationByPlatform(true);
        JPanel jPanel = new JPanel();
        jf.add(jPanel);
        placePanel(jPanel);
        jf.setVisible(true);

    }
    public static void placePanel(JPanel panel){
        panel.setLayout(null);
        JLabel jLabel = new JLabel("User:");
        jLabel.setBounds(130,60,80,25);
        panel.add(jLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(180,60,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100,100,80,25);
        panel.add(passwordLabel);

        JPasswordField pass = new JPasswordField(20);
        pass.setBounds(180,100,165,25);
        panel.add(pass);

        JButton login = new JButton("login");
        login.setBounds(300,150,80,25);
        panel.add(login);

        JButton register = new JButton("register");
        register.setBounds(130,150,80,25);
        panel.add(register);
    }
}
