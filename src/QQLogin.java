/**
 * @ProjectName Task
 * @ClassName QQLogin
 * Description
 * @Auther YunSW
 * @Date 2019/11/13 15:07
 * @Version 1.0
 **/

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class QQLogin {
    private static JFrame jf=new JFrame();
    public static void initLogin(){
        jf.setSize(426,300);
        jf.setLocation(497,242);
        jf.setUndecorated(true);
        jf.setResizable(false);
        BorderLayout border_layout=new BorderLayout();
        jf.setLayout(border_layout);
        JPanel panel_north=CreatePanel.CreateNorthPanel(jf);
        jf.add(panel_north,BorderLayout.PAGE_START);
        JPanel panel_center=CreatePanel.CreateCenterPanel(jf);
        jf.add(panel_center,BorderLayout.CENTER);
        JPanel panel_west=CreatePanel.CreateWestPanel();
        jf.add(panel_west,BorderLayout.LINE_START);
        JPanel panel_south=CreatePanel.CreateSouthPanel();
        jf.add(panel_south,BorderLayout.PAGE_END);
        JPanel panel_east=CreatePanel.CreateEastPanel();
        jf.add(panel_east,BorderLayout.LINE_END);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(QQLogin::initLogin);
    }
}


class CreatePanel {
    private static LoginListener ll=null;
    public static JPanel CreateNorthPanel(JFrame jf){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(0,140));
        ImageIcon image=new ImageIcon("images/back.jpg");
        JLabel background=new JLabel(image);
        background.setBounds(0,0,426,image.getIconHeight());
        panel.add(background);
        JButton out=new JButton(new ImageIcon("images/close_normal.jpg"));
        out.setBounds(403,0,26,26);
        out.setRolloverIcon(new ImageIcon("images/close_hover.jpg"));
        out.setBorderPainted(false);
        out.addActionListener(event->jf.dispose());
        panel.add(out);
        return panel;
    }
    public static JPanel CreateWestPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(130,0));
        ImageIcon image=new ImageIcon("images/qq.jpg");
        JLabel background=new JLabel(image);
        background.setBounds(0,0,120,110);
        panel.add(background);
        return panel;
    }
    public static JPanel CreateCenterPanel(JFrame jf){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        String str[]={"123456789","987654321","1214520888"};
        JComboBox<Object>jcoCenter=new JComboBox<Object>(str);
        panel.add(jcoCenter);
        jcoCenter.setEditable(true);
        jcoCenter.setBounds(0,15,175,30);
        jcoCenter.setFont(new Font("Calibri",0,13));
        JPasswordField jpaCenter=new JPasswordField();
        jpaCenter.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        jpaCenter.setBounds(0,44,175,30);
        jpaCenter.setPreferredSize(new Dimension(185,25));
        panel.add(jpaCenter);
        ImageIcon image=new ImageIcon("images/keyboard.jpg");
        JButton jbu=new JButton(image);
        jbu.setPreferredSize(new Dimension(22,20));
        jbu.setBorderPainted(false);
        jpaCenter.add(jbu);
        JCheckBox jch1=new JCheckBox("记住密码");
        jch1.setFocusPainted(false);
        jch1.setFont(new Font("宋体",0,13));
        jch1.setBounds(0,85,80,20);
        panel.add(jch1);
        JCheckBox jch2=new JCheckBox("自动登陆");
        jch2.setFocusPainted(false);
        jch2.setFont(new Font("宋体",0,12));
        jch2.setBounds(100,85,80,20);
        panel.add(jch2);
        ll=new LoginListener(jcoCenter,jpaCenter,jf);
        return panel;
    }
    public static JPanel CreateEastPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(100,0));
        JLabel regeist=new JLabel("注册账号");
        regeist.setForeground(new Color(100,149,238));
        regeist.setBounds(0,13,60,30);
        regeist.setFont(new Font("宋体",0,12));
        JLabel regetpwd=new JLabel("找回密码");
        regetpwd.setForeground(new Color(100,149,238));
        regetpwd.setBounds(0,43,60,30);
        regetpwd.setFont(new Font("宋体",0,12));
        panel.add(regetpwd);
        panel.add(regeist);
        return panel;
    }
    public static JPanel CreateSouthPanel(){
        JPanel panel=new JPanel();
        panel.setPreferredSize(new Dimension(0,51));
        panel.setLayout(null);
        JButton jble=new JButton(new ImageIcon("images/single_normal.jpg"));
        jble.setPreferredSize(new Dimension(40,40));
        jble.setFocusPainted(false);
        jble.setRolloverIcon(new ImageIcon("image/single_doen.jpg"));
        jble.setBorderPainted(false);
        jble.setContentAreaFilled(false);
        jble.setBounds(0,10,40,40);
        jble.setToolTipText("多账号登录");
        ImageIcon image=new ImageIcon("images/login_normal.jpg");
        JButton jb=new JButton("登          录",image);
        jb.setFont(new Font("宋体",0,13));
        jb.setBounds(130,0,175,40);
        jb.setHorizontalTextPosition(SwingConstants.CENTER);
        jb.setFocusPainted(false);
        jb.setContentAreaFilled(false);
        jb.setBorderPainted(false);
        jb.addActionListener(ll);
        jble.setRolloverIcon(new ImageIcon("image/login_hover.jpg"));
        JButton jbri=new JButton(new ImageIcon("images/right_normal.jpg"));
        jbri.setBounds(380,10,40,40);
        jbri.setFocusPainted(false);
        jbri.setBorderPainted(false);
        jbri.setContentAreaFilled(false);
        jbri.setRolloverIcon(new ImageIcon("image/right_normal.jpg"));
        jbri.setToolTipText("二维码登录");
        panel.add(jble);
        panel.add(jb);
        panel.add(jbri);
        return panel;
    }
}




class LoginListener implements ActionListener {
    private JComboBox<Object>jco;
    private JPasswordField jpa;
    private JFrame jf;
    public LoginListener(JComboBox<Object>jco,JPasswordField jpa,JFrame jf){
        super();
        this.jco=jco;
        this.jpa=jpa;
        this.jf=jf;
    }
    public void actionPerformed(ActionEvent e){
        String name=(String) jco.getSelectedItem();
        String pwd=new String(jpa.getPassword());
        if(name.equals("123456789")&&pwd.equals("123")){
            jf.dispose();
            JFrame jfn=new JFrame();
            jfn.setSize(289,687);
            jfn.setLocation(800,100);
            jfn.setUndecorated(true);
            jfn.setResizable(true);
            jfn.setVisible(true);
            JPanel panel=new JPanel();
            panel.setLayout(null);
            panel.setPreferredSize(new Dimension(0,140));
            ImageIcon image=new ImageIcon("images/qqSuccess.jpg");
            JLabel background=new JLabel(image);
            background.setBounds(0,0,289,687);
            panel.add(background);
            JButton out=new JButton(new ImageIcon("images/close2_normal.jpg"));
            out.setBounds(265,0,26,26);
            out.setRolloverIcon(new ImageIcon("images/close2_hover.jpg"));
            out.setBorderPainted(false);
            panel.add(out);
            jfn.add(panel);
            out.addActionListener(event->jfn.dispose());
        }else{
            JOptionPane.showMessageDialog(null,"你输入的账户名或密码不正确，请重新输入！");
        }
    }
}
