package chapter10;
import javax.swing.*;
import java.awt.*;
public class TextFieldEx extends JFrame{
    public TextFieldEx() {
        setTitle("텍스트필드 만들기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("이름   "));
        c.add(new JTextField(20));
        c.add(new JLabel("학과   "));
        c.add(new JTextField("컴공과",20));
        c.add(new JLabel("주소   "));
        c.add(new JTextField("서울시 ...",20));

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TextFieldEx();
    }
}
