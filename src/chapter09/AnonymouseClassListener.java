package chapter09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnonymouseClassListener extends JFrame{
    public AnonymouseClassListener(){
        setTitle("이벤트리스너 작성");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,120);
        setVisible(true);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        c.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");
            
            setTitle(b.getText());
            }
        });
    }
    public static void main(String[] args) {
        new AnonymouseClassListener();
    }
}
