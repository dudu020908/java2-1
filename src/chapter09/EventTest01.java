package chapter09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventTest01 extends JFrame {
	public EventTest01(){
		setTitle("이벤트리스너 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250,120);
		setVisible(true);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyAction());
		c.add(btn);
	}
	public static void main(String[] args) {
		new EventTest01();	
	}
}
	class MyAction implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			JButton b=(JButton)arg0.getSource();  //이벤트 발생한 소스를 얻는다
			if(b.getText().equals("Action"))
				b.setText("액션");
			else b.setText("Action");
	}
}