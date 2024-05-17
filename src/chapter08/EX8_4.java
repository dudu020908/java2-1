package chapter08;

import javax.swing.*;
import java.awt.*;

public class EX8_4 extends JFrame{
    public EX8_4(){
        setTitle("보더레이아웃예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        contentPane.setLayout(new BorderLayout(30,20));

        contentPane.add(new JButton("Calculate"),BorderLayout.CENTER);
        contentPane.add(new JButton("add"),BorderLayout.NORTH);
        contentPane.add(new JButton("sub"),BorderLayout.SOUTH);
        contentPane.add(new JButton("mul"),BorderLayout.EAST);
        contentPane.add(new JButton("div"),BorderLayout.WEST);
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EX8_4();
    }
}
