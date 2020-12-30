package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Random;

public class text extends JTextField
{
    private int x; //标签X坐标
    private int y; //标签Y坐标
    private int width; //宽度
    private int height; //高度
    JTextField jTextField = new JTextField();

    public text(JFrame jFrame, Container container,int x,int y,int width,int height)
    {
        jTextField.setLocation(x,y);
        jTextField.setSize(width,height);
        jTextField.setFont(new Font("微软雅黑",Font.BOLD,30));
        container.add(jTextField);

        //检测输入值是否为数字
        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(!Character.isDigit(e.getKeyChar()))
                {
                    e.consume();
                }
            }
        });
    }

    public void clear()
    {
        jTextField.setText("");
    }

    public String get()
    {
        return jTextField.getText();
    }

    public void set(String area,String count,String time)
    {
        HashSet<Integer> list = new HashSet<>();
        Random random = new Random();

        while(list.size()<new Integer(count))
        {
            int lucky = random.nextInt(new Integer(area))+1;
            list.add(lucky);
        }
        jTextField.setText(list.toString());
    }

}
