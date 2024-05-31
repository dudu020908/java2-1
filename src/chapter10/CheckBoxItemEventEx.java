package chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class CheckBoxItemEventEx extends JFrame{
    private JCheckBox[] fruits = new JCheckBox[3];
    private String [] names = {"사과","배","체리"};

    private JLabel sumLabel;

    public CheckBoxItemEventEx(){
        setTitle("체크박스와 아이템이벤트예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("사과100원, 배 500원, 체리 1000원"));

        // 3개의 체크박스 컴포넌트 생성, 컨텐츠팬에 삽입, 아이템리스너 등록

       MyItemListener listener = new MyItemListener();
        for(int i=0; i<fruits.length;i++){
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            c.add(fruits[i]);
            fruits[i].addItemListener(listener);
        }
        sumLabel = new JLabel("현재 0원입니다.");
        c.add(sumLabel);

        setSize(350,300);
        setVisible(true);
    }
    class MyItemListener implements ItemListener{
        private int sum = 0;


        public void itemStateChanged(ItemEvent e){
            if (e.getStateChange()==ItemEvent.SELECTED) {
                if(e.getItem()== fruits[0])
                sum +=100;
                else if(e.getItem()== fruits[1])
                sum +=500;
                else
                sum +=1000;
            }
            else {
                if(e.getItem()== fruits[0])
                sum -= 100;
                else if(e.getItem()== fruits[1])
                sum -=500;
                else
                sum -=1000;
            }
            sumLabel.setText("현재"+sum+"원입니다.");
        }
    }
    public static void main(String[] args) {
        new CheckBoxItemEventEx();
    }
}
