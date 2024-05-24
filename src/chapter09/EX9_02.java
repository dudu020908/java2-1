package chapter09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX9_02 extends JFrame{
    public EX9_02(){
        setTitle("이벤트 리스너예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,200);
        setVisible(true);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);
    }
    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton b = (JButton)e.getSource();
            if (b.getText().equals("Action"))
                b.setText("액션");
            else
                b.setText("Action"); 

        EX9_02.this.setTitle(b.getText());
        }
    }
    public static void main(String[] args) {
        new EX9_02();
    }
}