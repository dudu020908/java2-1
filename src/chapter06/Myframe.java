package chapter06;

import javax.swing.JFrame;

public class Myframe extends JFrame{
    public Myframe(){
        setTitle("300x300 스윙 프레임 만들기");
        setSize(300, 300);//크기 300x300
        setVisible(true);//프레임 출력 유무확인
    }
    public static void main(String[] args) {
        Myframe frame = new Myframe(); 
    }
    
}