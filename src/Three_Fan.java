import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DELL
 * @Date 2019/12/10 15:38
 **/
public class Three_Fan extends Frame implements ActionListener {
    MyPanel clockPanel;
    //the fan is on or off
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    int sign = 1;//延时的设计，使得三个风扇和一个风扇的转速保持一致
    //the angle of each fan(start)
    int [] angle1 = {90,90,90};
    int [] angle2 = {-90, -90, -90};
    int [] angle3 = {-180, -180, -180};
    int [] angle4 = {0, 0,0};
    //the speed of each fan.speed>0 or <0 represent direction
    int [] speed = {3,3,3};
    final Lock l = new ReentrantLock();
    Button start1 = new Button("Start");
    Button stop1 = new Button("Stop");
    Button reset1 = new Button("Reset");
    Button up_speed1 = new Button("UpSpeed");
    Button down_speed1 = new Button("DownS");

    Button start2 = new Button("Start");
    Button stop2 = new Button("Stop");
    Button reset2 = new Button("Reset");
    Button up_speed2 = new Button("UpSpped");
    Button down_speed2 = new Button("DownS");

    Button start3 = new Button("start");
    Button stop3 = new Button("Stop");
    Button reset3 = new Button("Reset");
    Button up_speed3 = new Button("UpSpeed");
    Button down_speed3 = new Button("DownS");

    Button start_all = new Button("Start_All");
    Button stop_all = new Button("Stop_All");
    Button ready_go = new Button("Ready_Go");

    //创建三个进程
    Run A = new Run();
    Run B = new Run();
    Run C = new Run();

    Three_Fan()
    {

        //draw panel
        clockPanel = new MyPanel();
        clockPanel.setLayout(null);
        start1.setBounds(5, 30, 50, 40);
        stop1.setBounds(55, 30, 50, 40);
        reset1.setBounds(105, 30, 50, 40);
        up_speed1.setBounds(155, 30, 50, 40);
        down_speed1.setBounds(205, 30, 50, 40);

        start2.setBounds(305, 30, 50, 40);
        stop2.setBounds(355, 30, 50, 40);
        reset2.setBounds(405, 30, 50, 40);
        up_speed2.setBounds(455, 30, 50, 40);
        down_speed2.setBounds(505, 30, 50, 40);

        start3.setBounds(605, 30, 50, 40);
        stop3.setBounds(655, 30, 50, 40);
        reset3.setBounds(705, 30, 50, 40);
        up_speed3.setBounds(755, 30, 50, 40);
        down_speed3.setBounds(805, 30, 50, 40);

        start_all.setBounds(125, 300, 120, 40);
        stop_all.setBounds(475, 300, 120, 40);
        ready_go.setBounds(775, 300, 100, 40);


        //action listener
        start1.addActionListener(this);
        stop1.addActionListener(this);
        reset1.addActionListener(this);
        up_speed1.addActionListener(this);
        down_speed1.addActionListener(this);

        start2.addActionListener(this);
        stop2.addActionListener(this);
        reset2.addActionListener(this);
        up_speed2.addActionListener(this);
        down_speed2.addActionListener(this);

        start3.addActionListener(this);
        stop3.addActionListener(this);
        reset3.addActionListener(this);
        up_speed3.addActionListener(this);
        down_speed3.addActionListener(this);

        start_all.addActionListener(this);
        stop_all.addActionListener(this);
        ready_go.addActionListener(this);


        //add
        add(start1);
        add(stop1);
        add(reset1);
        add(up_speed1);
        add(down_speed1);

        add(start2);
        add(stop2);
        add(reset2);
        add(up_speed2);
        add(down_speed2);

        add(start3);
        add(stop3);
        add(reset3);
        add(up_speed3);
        add(down_speed3);

        add(start_all);
        add(stop_all);
        add(ready_go);

        add(clockPanel);
    }

    //action listener function
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ready_go)
        {
            A.start();
            B.start();
            C.start();
        }
        else if(e.getSource() == start1)
        {
            flag1 = true;
        }
        else if(e.getSource() == stop1)
        {
            flag1 = false;
        }
        else if(e.getSource() == reset1)
        {
            angle1[0] = 90;
            angle2[0] = -90;
            angle3[0] = -180;
            angle4[0] = 0;
        }
        else if(e.getSource()==up_speed1){
            speed[0]+=1;
        }
        else if(e.getSource()==down_speed1){
            speed[0]-=1;
        }


        else if(e.getSource() == start2)
        {
            flag2 = true;
        }
        else if(e.getSource() == stop2)
        {
            flag2 = false;
        }
        else if(e.getSource() == reset2)
        {
            angle1[1] = 90;
            angle2[1] = -90;
            angle3[1] = -180;
            angle4[1] = 0;
        }
        else if(e.getSource()==up_speed2){
            speed[1]+=1;
        }
        else if(e.getSource()==down_speed2){
            speed[1]-=1;
        }


        else if(e.getSource() == start3)
        {
            flag3 = true;
        }
        else if(e.getSource() == stop3)
        {
            flag3 = false;
        }
        else if(e.getSource() == reset3)
        {
            angle1[2] = 90;
            angle2[2] = -90;
            angle3[2] = -180;
            angle4[2] = 0;

        }
        else if(e.getSource()==up_speed3){
            speed[2]+=1;
        }
        else if(e.getSource()==down_speed3){
            speed[2]-=1;
        }


        else if(e.getSource() == start_all)
        {
            flag1 = true;
            flag2 = true;
            flag3 = true;
        }
        else if(e.getSource() == stop_all)
        {
            flag1 = false;
            flag2 = false;
            flag3 = false;
        }
    }

    class MyPanel extends JPanel
    {
        @Override
        public void paint(Graphics g) {


            //第一个
            g.setColor(Color.yellow);
            g.fillArc(20, 40, 200, 200, angle1[0], -30);
            g.fillArc(20, 40, 200, 200, angle2[0], -30);
            g.fillArc(20, 40, 200, 200, angle3[0], -30);
            g.fillArc(20, 40, 200, 200, angle4[0], -30);


            //第二个
            g.setColor(Color.red);
            g.fillArc(320, 40, 200, 200, angle1[1], -30);
            g.fillArc(320, 40, 200, 200, angle2[1], -30);
            g.fillArc(320, 40, 200, 200, angle3[1], -30);
            g.fillArc(320, 40, 200, 200, angle4[1], -30);

            //第三个
            g.setColor(Color.green);
            g.fillArc(620, 40, 200, 200, angle1[2], -30);
            g.fillArc(620, 40, 200, 200, angle2[2], -30);
            g.fillArc(620, 40, 200, 200, angle3[2], -30);
            g.fillArc(620, 40, 200, 200, angle4[2], -30);
        }
    }


    //Main
    public static void main(String[] args)  {
        Three_Fan window = new Three_Fan();
        window.addWindowListener(new WindowAdapter()  //为了关闭窗口
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        window.setBounds(400, 200, 900, 350);
        window.setTitle("My_Fan(2013211842-黄麟)");
        window.setVisible(true);
        window.setLayout(null);
        window.setResizable(false);
    }

    //paint repaint
    void lfl(int state)
    {
        angle1[state] += speed[state];
        angle2[state] += speed[state];
        angle3[state] += speed[state];
        angle4[state] += speed[state];
        try
        {
            Thread.sleep(100/sign);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        repaint();
    }


    //Thread
    private class Run extends Thread
    {
        @Override
        public void run()
        {
            while (true) {
                l.lock();

                if(flag1 == false && flag2 == false && flag3 == false)
                {
                    sign = 1;
                    continue
                            ;
                }
                else if(flag1 == false && flag2 == false && flag3 == true)
                {
                    sign = 1;
                    lfl(2);
                }
                else if(flag1 == false && flag2 == true && flag3 == false)
                {
                    sign = 1;
                    lfl(1);
                }
                else if(flag1 == false && flag2 == true && flag3 == true)
                {
                    sign = 2;
                    lfl(2);
                    lfl(1);
                }
                else if(flag1 == true && flag2 == false && flag3 == false)
                {
                    sign = 1;
                    lfl(0);
                }
                else if(flag1 == true && flag2 == false && flag3 == true)
                {
                    sign = 2;
                    lfl(2);
                    lfl(0);
                }
                else if(flag1 == true && flag2 == true && flag3 == false)
                {
                    sign = 2;
                    lfl(1);
                    lfl(0);
                }
                else if(flag1 == true && flag2 == true && flag3 == true)
                {
                    sign = 3;
                    lfl(2);
                    lfl(1);
                    lfl(0);
                }


                l.unlock();
            }
        }
    }
}
