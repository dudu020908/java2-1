package chapter09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseAdapterEx extends JFrame{
    private JLabel la = new JLabel("Hello");

    public MouseAdapterEx(){
        setTitle("마우스이벤트 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,200);
        setVisible(true);

        Container c = getContentPane();
        c.addMouseListener(new MyMouseAdapter());

        c.setLayout(null);
        la.setSize(50,20);
        la.setLocation(30,30);
        c.add(la);
    }
    class MyMouseAdapter extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x,y);
        }
    }
    public static void main(String[] args) {
        new MouseAdapterEx();
    }
}
