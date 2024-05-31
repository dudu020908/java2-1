package chapter09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import chapter09.MouseListenerEx.MyMouseListener;

public class MouseEventAllEx extends JFrame{
    private JLabel la = new JLabel("   Move Me");

    public MouseEventAllEx(){
      setTitle("마우스리스너와 모션리스너예제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      
      MyMouseListener listener = new MyMouseListener();
      c.addMouseListener(listener);
      c.addMouseMotionListener(listener);

      c.setLayout(null);

      la.setSize(80,20);
      la.setLocation(100,80);
      c.add(la);

      setSize(320,200);
      setVisible(true);
    }
    class MyMouseListener implements MouseListener,MouseMotionListener{
        public void mousePresssed(MouseEvent e){}
    }
    public static void main(String[] args) {
      new MouseEventAllEx();
    }
}
