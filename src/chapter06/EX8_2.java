package chapter06;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

public class EX8_2 extends JFrame{
    public EX8_2(){
        setTitle("ContentPane과 JFrame 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우 닫으면 프로그램 종료 *중요함 없으면 뒤에 계속남음

        Container ContentPane = getContentPane();
        ContentPane.setBackground(Color.ORANGE);
        ContentPane.setLayout(new FlowLayout());

        ContentPane.add(new JButton("OK"));
        ContentPane.add(new JButton("Cancle"));
        ContentPane.add(new JButton("Ignore"));

        setSize(300,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EX8_2();
    }
}
