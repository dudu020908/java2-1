package chapter09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseListenerEx extends JFrame{
    private JLabel la =new JLabel("Hello"); // Hello 문자열을 출력하기 위한 레이블

    public MouseListenerEx(){
        setTitle("마우스이벤트 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,200);
        setVisible(true);

        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null);
        la.setSize(50,20);
        la.setLocation(30,30);
        c.add(la);
    }
    class MyMouseListener implements MouseListener{
        public void mousePressed(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
        public void mouseReleased(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
    }
    public static void main(String[] args) {
        new MouseListenerEx();
    }
}
