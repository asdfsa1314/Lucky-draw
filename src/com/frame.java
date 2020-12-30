package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class frame implements ActionListener
{
    JFrame jFrame;
    public frame()
    {

        jFrame = new JFrame();

        Container container = jFrame.getContentPane(); //获取窗体容器
        container.setLayout(null);

        jFrame.setTitle("抽奖活动"); //设置标题
        jFrame.setSize(600,560); //设置窗体尺寸
        jFrame.setLocationRelativeTo(null); //设置窗体显示居中


//        jFrame.getContentPane().setBackground(Color.DARK_GRAY); //设置窗体背景色



        jFrame.setResizable(true); //禁止调整窗体大小
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置关闭操作

        label numberLabel = new label(jFrame,container,15,10,"获奖号码：");
        label areaLabel = new label(jFrame,container,15,110,"号码范围：");
        label countLabel = new label(jFrame,container,15,210,"得奖人数：");
        label timeLabel = new label(jFrame,container,15,310,"摇奖时间：");

        text numberText = new text(jFrame,container,160,10,400,60); //得奖号码
        text areaText = new text(jFrame,container,160,110,100,50); //数值范围
        text countText = new text(jFrame,container,160,210,100,50); //获奖人数
        text timeText = new text(jFrame,container,160,310,100,50); //摇奖时间

        try {
            int i = Integer.parseInt(timeText.get());
            Timer timer = new Timer(i, this);
            timer.start();
        }catch (NumberFormatException n){

        }

        //开始按钮
        JButton start = new JButton();
        start.setBounds(50,410,120,50);
        start.setText("开始抽奖");
        start.setFont(new Font("微软雅黑",Font.BOLD,20));
        container.add(start);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String a = areaText.get();
                    String c = countText.get();
                    String t = timeText.get();
                    numberText.set(a,c,t);
            }
        });

        //清空按钮
        JButton clear = new JButton();
        clear.setBounds(220,410,120,50);
        clear.setText("清空");
        clear.setFont(new Font("微软雅黑",Font.BOLD,20));
        container.add(clear);

        //清空动作监听
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberText.clear();
                areaText.clear();
                countText.clear();
                timeText.clear();
            }
        });

        //退出按钮
        JButton exit = new JButton();
        exit.setBounds(390,410,120,50);
        exit.setText("退出");
        exit.setFont(new Font("微软雅黑",Font.BOLD,20));
        container.add(exit);

        //退出动作监听
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        container.validate(); //验证窗体中的容器
        jFrame.setVisible(true); //设置窗体显示
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       frame a = (frame)e.getSource();
        Random r = new Random();
        int r1 = r.nextInt(100);
        int r2 = r.nextInt(100);
        int r3 = r.nextInt(100);
       a.jFrame.getContentPane().setBackground(new Color(r1,r2,r3));
    }
}
