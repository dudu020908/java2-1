package chapter12;
import java.awt.*;
import javax.swing.*;

class TimerRunnable implements Runnable {
    private JLabel timerLabel;
    public TimerRunnable(JLabel timerLabel){
        this.timerLabel =timerLabel;
    }
    @Override
    public void run(){
        int n=0;
        while (true) {
            timerLabel.setText(Integer.toString(n));
            n++;
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                return;
            }
        }
    }
}
public class RunnableTimerEx extends JFrame{
    RunnableTimerEx(){
        setTitle("러너블을 구현한타이머 스레드예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
        c.add(timerLabel);

        setSize(250,150);
        setVisible(true);

        TimerRunnable runnable = new TimerRunnable(timerLabel);
        Thread th =new Thread(runnable);
        th.start();
    }
    public static void main(String[] args) {
        new RunnableTimerEx();
    }
}

