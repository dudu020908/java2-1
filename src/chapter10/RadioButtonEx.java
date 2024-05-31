package chapter10;
import javax.swing.*;
import java.awt.*;
public class RadioButtonEx extends JFrame{
    public RadioButtonEx(){
        setTitle("라디오 버튼만들기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ButtonGroup g = new ButtonGroup();

        JRadioButton apple = new JRadioButton("사과");
        JRadioButton pear = new JRadioButton("배",true);
        JRadioButton cherry = new JRadioButton("체리");

        g.add(apple);
        g.add(cherry);
        g.add(pear);

        c.add(apple); c.add(pear); c.add(cherry);

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new RadioButtonEx();
    }
}
