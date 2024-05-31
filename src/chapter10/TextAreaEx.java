package chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TextAreaEx extends JFrame{
    private JTextField tf = new JTextField(20);
    private JTextArea ta = new JTextArea(7,20); // 한줄에 20개 입력가능한 7줄의 입력창

    public TextAreaEx(){
        setTitle("텍스트영역만들기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("입력 후 <ENTER>키를 입력하세요!"));
        c.add(tf);
        c.add(new JScrollPane(ta));
        //텍스트 필드에 액션 리스너 등록
        tf.addActionListener(new ActionListener() { // 엔터키 입력시 작동 리스너
            public void actionPerformed(ActionEvent e){
                JTextField t = (JTextField)e.getSource();
                ta.append(t.getText()+"\n"); // 텍스트 필드 문자열을 텍스트 영역에 붙임
                t.setText(""); //현재 텍스트 필드에 입력된 내용 지우기
            }
        });
        setSize(300,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TextAreaEx();
    }
}
