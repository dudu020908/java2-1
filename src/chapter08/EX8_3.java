package chapter08;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
class EX8_3  extends JFrame{
    public EX8_3(){
        setTitle("플로우레이아웃 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane(); //컨텐트팬 알아내기

        //왼쪽정령로 수평 30 수직 40픽셀 배치 플로우 레이아웃 생성
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));

        contentPane.add(new JButton("add"));
        contentPane.add(new JButton("sub"));
        contentPane.add(new JButton("mul"));
        contentPane.add(new JButton("div"));
        contentPane.add(new JButton("Calculate"));

        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EX8_3();
    }
}