package chapter10;
import javax.swing.*;
import java.awt.*;
public class CheckBoxEx extends JFrame{
    public CheckBoxEx(){
        setTitle("체크박스 만들기 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");

        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배",true);
        JCheckBox cherry = new JCheckBox("체리",normalIcon);

        c.add(apple);
        c.add(pear);
        c.add(cherry);

        setSize(250,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CheckBoxEx();
    }
}