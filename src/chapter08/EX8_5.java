package chapter08;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class EX8_5 extends JFrame{
    public EX8_5(){
        super("그리드레이아웃예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contanePane = getContentPane();

        contanePane.setLayout(new GridLayout(1,10));

        for(int i=0;i<10;i++){
            String text = Integer.toString(i);
            JButton button = new JButton(text);
            contanePane.add(button);
        }
        setSize(500,200);
        setVisible(true);
    }   
    public static void main(String[] args) {
        new EX8_5();
    }
}
