package com;

import javax.swing.*;
import java.awt.*;

public class label extends JLabel
{
    private int x; //标签X坐标
    private int y; //标签Y坐标
    private String content; //文本内容

    public label(JFrame jFrame,Container container,int x,int y,String content)
    {
        JLabel jLabel = new JLabel();
        jLabel.setText(content);
        jLabel.setBounds(x,y,160,50);
        jLabel.setFont(new Font("微软雅黑",Font.BOLD,30));
        container.add(jLabel);
    }
}
