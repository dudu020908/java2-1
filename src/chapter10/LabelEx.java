package chapter10;
import javax.swing.*;
import java.awt.*;
public class LabelEx extends JFrame{
    public LabelEx(){
        setTitle("레이블예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel textLabel = new JLabel("제임스 고슬링 입니더!");

        ImageIcon img = new ImageIcon("images/gosling.jpg");
        JLabel imageLabel = new JLabel(img);

        ImageIcon icon = new ImageIcon("images/icon.gif");
        JLabel label = new JLabel("커피한잔 하실래예, 전화주이소",icon,SwingConstants.CENTER);

        c.add(textLabel);
        c.add(imageLabel);
        c.add(label);

        setSize(600,900);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LabelEx();
    }
}
