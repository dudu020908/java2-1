package chapter11;

import javax.swing.*;
import java.awt.*;
public class GraphicsDrawImageEx1 extends JFrame{
    public GraphicsDrawImageEx1(){
        setTitle("원본크기원하는위치에 이미지 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(300,400);
        setVisible(true);
    }

    class MyPanel extends JPanel{
        private ImageIcon icon = new ImageIcon("images/icon.gif");
        private Image img = icon.getImage();

        public void paintComponent(Graphics g){
            super.paintComponent(g);


            g.drawImage(img,20,20,this);
        }
    }
    public static void main(String[] args) {
        new GraphicsDrawImageEx1();
    }
}
