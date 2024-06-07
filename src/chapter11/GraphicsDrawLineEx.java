package chapter11;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
public class GraphicsDrawLineEx extends JFrame{
    public GraphicsDrawLineEx() {
        setTitle("문자열, 컬러,폰트 사용예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(250,200);
        setVisible(true);
    }
     class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawLine(20, 20, 100, 100);
            }
        }
    public static void main(String[] args) {
        new GraphicsDrawLineEx();
    }
}
    
