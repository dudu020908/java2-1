package chapter11;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
public class GraphicsColorFontEx extends JFrame{
    public GraphicsColorFontEx() {
        setTitle("문자열, 컬러,폰트 사용예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(250,200);
        setVisible(true);
    }
     class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawString("자바가 재밌다.",30, 30);
            g.setColor(new Color(255,0,0));
            g.setFont(new Font("Arial",Font.ITALIC,30));
            g.drawString("How much?",30,70);
            g.setColor(new Color(0x00ff00ff));

            for(int i=1; i<=4;i++){
                g.setFont(new Font("Jokerman",Font.ITALIC,i*10));
                g.drawString("This much!", 30,60+ i*40);
            }
        }
    }
    public static void main(String[] args) {
        new GraphicsColorFontEx();
    }
}