# 이도원 학번 201840126
#### 6월 14일 강의   
**입출력 스트림과 파일 입출력**   
**자바의 입출력 스트림**   
- 입출력 장치와 자바 응용프로그램 연결   
1. 입력스트림 : 입력장치로부터 자바프로그램으로 데이터를 전달하는 객체   
2. 출력스트림 : 응용프로그램으로 부터 출력장치로 데이터를 보내는 객체   
   
- 특징   
입출력 스트림 기본단위 : 바이트   
단방향 스트림 : 선입 선출구조   
   
**문자 스트림**   
- 문자만 입출력하는 스트림   
- 문자가 아닌 바이너리 데이터는 처리X   

**문자 스트림으로 텍스트 파일 읽기**   
텍스트 파일을 읽기 위해 문자 스트림 파일리더 클래스 이용   
1. 파일입력 스트림 생성   
스트림을 생성후 파일을 열어 스트림과 연결   
2. 파일 읽기   
3. 스트림 닫기   
   
파일 입출력중 예외사항   
파일 낫파운드(파일경로명, 디스크의 고장등), IO 오류 발생 가능(디스크 오동작, 중간에 파일깨짐, 디스크공간 부족등)   
   
예제 13-1   
```
package chapter13;
import java.io.*;
public class FileReaderEx {

    public static void main(String[] args) {
        FileReader in = null;
        try{
            in = new FileReader("c:\\windows\\system.ini");
            int c;
            while ((c= in.read())!= -1) {
                System.out.print((char)c);
            }
            in.close();
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
    }
}
```   
   
예제 13-2   
```
package chapter13;

import java.io.*;

public class FileWriterEx {

    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);

        FileWriter fout = null;
        int c;
        try{
            fout = new FileWriter("c:\\temp\\test.txt");
            
            while ((c= in.read())!= -1) {
                fout.write(c);
            }
            in.close();
            fout.close();
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
    }
}



```   
   
예제 13-3   
```
package chapter13;

import java.io.*;

public class FileOutputStreamEx {
    public static void main(String[] args) {
        byte b[]={7,51,3,4,-1,24};
        
        try{
            FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
            for(int i=0;i<b.length;i++)
                fout.write(b[i]);
            fout.close();
        } catch(IOException e) { }
        System.out.println("c:\\Temp\\test.out을 저장하였습니다.");
    }
}

```   
   
예제 13-4   
```
package chapter13;
import java.io.*;
public class FileInputStreamEx {
    public static void main(String[] args) {
        byte b[]= new byte[6];
        try {
            FileInputStream fin = new FileInputStream("c:\\Temp\\test.out");
            int n=0,c;
            while ((c= fin.read())!=-1) {
                b[n]=(byte)c;
                n++;
            }
            System.out.println("c:\\\\Temp\\\\test.out에서읽은 배열을 출력합니다.");
            for(int i=0;i<b.length;i++)
                    System.out.print(b[i]+ " ");
            System.out.println();
            fin.close();
        } catch (Exception e) {}
    }
}

```   
   
예제 13-5   
```
package chapter13;
import java.io.*;
public class FileClassExample {
    public static void listDirectory(File dir) {
        System.out.println("-----"+dir.getPath()+"의 서브리스트입니다.-----");
        File[] subFiles = dir.listFiles();

        for(int i= 0;i<subFiles.length;i++){
            File f = subFiles[i];
            long t = f.lastModified();
            System.out.print(f.getName());
            System.out.print("\t파일크기: "+f.length());
            System.out.printf("\t수정한 시간 : %tb %td %ta %tT\n",t,t,t,t);
        }
    }
    public static void main(String[] args) {
        File f1 = new File("c:\\windows\\system.ini");
        System.out.println(f1.getPath()+", "+f1.getParent()+ ", "+f1.getName());

        String res ="";
        if (f1.isFile()) res = "파일"; 
        else if (f1.isDirectory()) res = "디렉토리"; 
        System.out.println(f1.getPath()+"은 "+res + "입니다.");    
        
        
    }
}

```   
   
##### **TCP/IP 소개**   
두 시스템간에 데이터가 손상없이 전송되도록 하는 프로토콜   
연결형 통신, 한번 연결후 쭉 전송가능   
IP 주소   
네트워크 상에서 유일하게 식별될 수 있는 인터넷 주소   
   
**포트**   
통신 프로그램간 포트생성   
- IP 주소는 네트워크상 컴퓨터 또는 시스템을 식별 주소   
- 포트 번호 이용 통신 응용 프로그램 식별   
   
모든 응용 프로그램은 하나이상의 포트를 생성 가능   
포트번호는 응용프로그램 개발자가 임의로 결정하여 사용   
기존 프로그램에서 이미 사용중인 포트는 피하는게 좋음   
이를 **잘 알려진 포트** 라고함   
  
**소켓**   
TCPIP 네트워크를 이용해 쉽게 통신 프로그램을 작성하도록 지원   
양방향 통신링크의 끝 단   
소켓끼리 데이터를 주고받음   
종류 : 서버, 클라이언트   

#### 6월 7일 강의   
**스윙 컴포넌트 그리기 paintComponent()**   
- 스윙의 페인팅 기본   
모든 컴포넌트는 자신의 모양을 스스로 그림    
컨테이너는 자신을 그린 후 그위에 자식 컴포넌트들에게 그리기 지시   
모든 스윙 컴포넌트는 자신의 모양을 그리는 페인트 컴포넌트 보유   
   
**오버로딩과 판넬**   
- 오버라이딩 개발자가 컴포넌트 상속받아 새 컴포넌트 설계   
- 기존 컴포넌트의 모양에 변화를 주려할때   
- 판넬 비어있는 컨테이너    
- 개발자가 다양한거 하려할 때   
   
예제 11-1   
```
package chapter11;
import javax.swing.*;
import java.awt.*;
public class paintJPanelEx extends JFrame{
    public paintJPanelEx(){
        setTitle("j판넬의 페인트 컴포넌트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(250,200);
        setVisible(true);
    }
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(10,10,50,50);
            g.drawRect(50,50,50,50);

            g.setColor(Color.MAGENTA);
            g.drawRect(90, 90, 50, 50);
        }
    }
    public static void main(String[] args) {
        new paintJPanelEx();
    }
}

```   
컴포넌트의 한계 극복 차트, 게임등 자유로운 콘텐트 표현   
그래픽은 컴포넌트에 비해 화면 출력 속도 빠름   
**Graphics와 문자열 출력**   
그래픽의 기능   
색상 선택   
문자열그리기   
도형 그리기   
도형 칠하기   
이미지 그리기   
클리핑   
색: Color 클래스   
폰트: Font 클래스  
예제11-2
```
package chapter11;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
public class GraphicsColorFontEx extends JFrame{
    public GraphicsColorFontEx() {
        setTitle("문자열, 컬러,폰트 사용예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(250,200);
        setVisible(true);
    }
     class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawString("자바가 재밌다.",30, 30);
            g.setColor(new Color(255,0,0));
            g.setFont(new Font("Arial",Font.ITALIC,30));
            g.drawString("How much?",30,70);
            g.setColor(new Color(0x00ff00ff));

            for(int i=1; i<=4;i++){
                g.setFont(new Font("Jokerman",Font.ITALIC,i*10));
                g.drawString("This much!", 30,60+ i*40);
            }
        }
    }
    public static void main(String[] args) {
        new GraphicsColorFontEx();
    }
}

```   
도형그리기와 칠하기   
예제11-3   
```
package chapter11;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
public class GraphicsDrawLineEx extends JFrame{
    public GraphicsDrawLineEx() {
        setTitle("drawline예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(250,200);
        setVisible(true);
    }
     class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawLine(20, 20, 100, 100);
            }
        }
    public static void main(String[] args) {
        new GraphicsDrawLineEx();
    }
}
    

```   
   
예제 11-4   
```
package chapter11;



import javax.swing.*;
import java.awt.*;
public class GraphicsFillEx extends JFrame{
    public GraphicsFillEx() {
        setTitle("fill사용예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(250,500);
        setVisible(true);
    }
     class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(10,10, 50, 50);
            g.setColor(Color.BLUE);
            g.fillOval(10,70, 50, 50);
            g.setColor(Color.GREEN);
            g.fillRoundRect(10, 130, 50,50,20,20);
            g.setColor(Color.MAGENTA);
            g.fillArc(10,190,50,50,0,270);
            g.setColor(Color.ORANGE);
            int[]x = {30,10,30,60};
            int[]y = {250,275,300,275};
            g.fillPolygon(x,y,4);
            }
        }
    public static void main(String[] args) {
        new GraphicsFillEx();
    }
}
    

```   
**이미지 그리는 2가지방법**   
J라벨을 이용한 이미지 그리기   
그래픽의 Draw이미지로 이미지그리기   
예제11-5   
```
package chapter11;

import javax.swing.*;
import java.awt.*;
public class GraphicsDrawImageEx1 extends JFrame{
    public GraphicsDrawImageEx1(){
        setTitle("원본크기원하는위치에 이미지 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(300,400);
        setVisible(true);
    }

    class MyPanel extends JPanel{
        private ImageIcon icon = new ImageIcon("images/icon.gif");
        private Image img = icon.getImage();

        public void paintComponent(Graphics g){
            super.paintComponent(g);


            g.drawImage(img,20,20,this);
        }
    }
    public static void main(String[] args) {
        new GraphicsDrawImageEx1();
    }
}

```   
   
예제 11-6   
```
package chapter11;

import javax.swing.*;
import java.awt.*;
public class GraphicsDrawImageEx2 extends JFrame{
    public GraphicsDrawImageEx2(){
        setTitle("패널크기에 맞춰 이미지 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(300,400);
        setVisible(true);
    }

    class MyPanel extends JPanel{
        private ImageIcon icon = new ImageIcon("images/icon.gif");
        private Image img = icon.getImage();

        public void paintComponent(Graphics g){
            super.paintComponent(g);


            g.drawImage(img,0,0,getWidth(),getHeight(),this);
        }
    }
    public static void main(String[] args) {
        new GraphicsDrawImageEx2();
    }
}

```   

다시그리기repaint()   
예제 11-7   
```
package chapter11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GraphicsDrawOvalMouseEx extends JFrame{
    public GraphicsDrawOvalMouseEx(){
        setTitle("마우스 드래그로 타원그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GraphicsDrawOvalMouseEx();
    }
    class MyPanel extends JPanel{
        private Point start=null, end=null;
        public MyPanel(){
            MyMouseListener listener = new MyMouseListener();

            addMouseListener(listener);
            addMouseMotionListener(listener);
        }
        class MyMouseListener extends MouseAdapter{
            public void mousePressed(MouseEvent e){
                start = e.getPoint();
            }
            public void mouseDragged(MouseEvent e){
                end =e.getPoint();
                repaint();
            }
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if (start==null) 
                return;

                g.setColor(Color.BLUE);
                int x = Math.min(start.x,end.x);
                int y = Math.min(start.y, start.y);

                int width=Math.abs(start.x-end.x);
                int height=Math.abs(start.y-end.y);
                g.drawOval(x, y, width, height);
            }
        }
    }


```   
예제11-8   
```
package chapter11;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class GraphicsDrawLineMouseEx extends JFrame{
    public GraphicsDrawLineMouseEx(){
        setTitle("마우스로 여러개의선그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GraphicsDrawLineMouseEx();
    }
    class MyPanel extends JPanel{
        private Vector<Point> vStart = new Vector<Point>();
        private Vector<Point> vEnd = new Vector<Point>();

        public MyPanel(){

            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e){
                    Point startP = e.getPoint();
                    vStart.add(startP);
                }
                public void mouseReleased(MouseEvent e){
                    Point endP = e.getPoint();
                    vEnd.add(endP);

                    repaint();
                }
            });
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);

            for(int i=0;i<vStart.size();i++){
                Point s = vStart.elementAt(i);
                Point e = vEnd.elementAt(i);

                g.drawLine((int)s.getX(),(int)s.getY(),(int)e.getX(),(int)e.getY());
            }
        }
    }
}

```   
##### 12장 스레드   
멀티태스킹   
- 여러개의 작업이 동시에 처리되는것을 뜻함   
   
스레드   
- 운영체제에 의해 관리되는 하나의 작업혹은 테스크   
- 스레드와 테스크는 바꾸어 사용해도 무관하다   
   
멀티스레딩   
- 여러 스레드를 동시에 실행 시키는 응용 프로그램을 작성하는기법   
   
스레드 구성   
- 스레드 코드   작업을 실행하기위해 작성한 프로그램 코드 스레드정보   
멀티 태스킬 구현 기술   
- 멀티프로세싱   
- 하나의 응용 프로그램이 여러 개의 프로세스를 생성하고, 각프로세스가 하나의 작업을 처리하는 기법   
- 각 프로세스 독립된 메모리 영역을 보유하고 실행   
- 프로세스 사이의 문맥 교환에 따른 과도한 오버헤드와 시간소모의 문제점   
   
멀티스레딩   
- 하나의 응용프로그햄이 여러개의 스레드를 생성하고 각 스레드가 하나의 작업을 처리하는과정   
- 하나의 응용프로그램에 속한 스레드는 변수메모리, 파일 오픈 테이블등 자원으로 공유하므로, 문맥교환에 따른 오버헤드가 매우 작음   
- 현재 대부분의 운영체제가 멀티스레딩을 기본으로 하고있음   
   
자바 스레드
- JVM에 의해 스케쥴 되는 실행단위의 코드블럭   
- 스레드의 생명주기는 JVM에 의해 관리   
   
JVM은 하나의 응용프로그램만 실행   
함께 실행, 함께 종료   
응용프로그램은 하나이상의 스레드로 구성 가능   

예제12-1   
```
package chapter12;
import java.awt.*;
import javax.swing.*;
class TimerThread extends Thread{
    private JLabel timerLabel;

    public TimerThread(JLabel timerLabel){
        this.timerLabel=timerLabel;
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

public class ThreadTimerEx extends JFrame{
    public ThreadTimerEx(){
        setTitle("스레드 상속받은 타이머 스레드예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
        c.add(timerLabel);

        TimerThread th = new TimerThread(timerLabel);

        setSize(250,150);
        setVisible(true);

        th.start();
    }
    public static void main(String[] args) {
        new ThreadTimerEx();
    }
}
```   
예제12-2   
```
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


```   
   
예제 12-3   
```
package chapter12;

public class ThreadMainEx {
    public static void main(String[] args) {
        long id=Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        Thread.State s = Thread.currentThread().getState();

        System.out.println("현재스레드이름 = "+name);
        System.out.println("현재스레드ID = "+id);
        System.out.println("현재스레드우선순위값 = "+priority);
        System.out.println("현재스레드상태 = "+s);
    }
}

```   
   
예제 12-4   
```
package chapter12;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class VibratingFrame extends JFrame implements Runnable{
    private Thread th;
    public VibratingFrame(){
        setTitle("진동하는 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);
        setLocation(300,300);
        setVisible(true);

        getContentPane().addMouseListener(new MouseAdapter() {
           public void mousePressed(MouseEvent e){
            if(!th.isAlive()) return; 
            th.interrupt();
            }   
        });
        th = new Thread(this);
        th.start();
    }
    @Override
    public void run(){
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(20);
            }
            catch(InterruptedException e){
                return;
            }
            int x = getX() + r.nextInt()%5;
            int y = getY() + r.nextInt()%5;
            setLocation(x,y);
        }
    }
    public static void main(String[] args) {
        new VibratingFrame();
    }
}

```   
##### **스레드 동기화**   
멀티스레드 작성시 주의사항   
###### 다수의 스레드가 공유 데이터에 동시에 접근하는경우
- 공유 데이터의 값에 예상치 못한 결과가 발생할수 있음   
   
스레드 동기화   
동기화란?   
스레드 사이의 실행순서 제어, 공유데이터에 대한 접근을 원할하게 하는기법을 뜻함   
멀티스레드의 공유 데이터의 동시접근 문제 해결   
1. 공유 데이터를 접근하는 모든스레드의 한 줄 세우기   
2. 한 스레드가 공유데이터에 대한 작업을 끝낼 때까지 다른 스레드가 대기하도록 함   
   
자바의 스레드 동기화 방법 - 2가지   
- 싱크로나이즈드 키워드로 동기화 블록 지정   
- wait() - notify() 메소드로 스레드의 실행순서를 제어   
예제 12-5   
```
package chapter12;

public class SynchronizedEx {
    public static void main(String[] args) {
        SharedPrinter p = new SharedPrinter();
        String[] engText ={};
        String[] korText ={};

        Thread th1= new WorkerThread(p,engText);
        Thread th2= new WorkerThread(p,korText);

        th1.start();th2.start();
    }
}
class SharedPrinter{
    synchronized void print(String text){
        for(int i=0; i<text.length();i++)
        System.out.print(text.charAt(i));
        System.out.println();
    }
}
class WorkerThread extends Thread{
    private SharedPrinter p;
    private String [] text;

    public WorkerThread(SharedPrinter p,String[] text){
        this.p = p; this.text = text;
    }
    @Override
    public void run(){
        for(int i=0; i<text.length; i++)
        p.print(text[i]);
    }
}

```   
wait notify 필요한경우     
공유 데이터로 두개 이상의 스레드가 데이터를 주고 받을때   
   
#### 5월 31일 강의
**자바의 GUI 프로그래밍 방법 2종류**   
컴포넌트 기반   
- 스윙 컴포넌트 이용 쉽게 구축   
- 자바에서 제공하는 컴포넌트 한계 벗어나지못함   
   
그래픽 기반   
   
스윙 컴포넌트의 공통 메소드, J컴포넌트의 메소드   
J컴포넌트   
스윙 컴포넌트는 모두 상속받는 슈퍼,추상 클래스   
스윙 컴포넌트들이 상속받는 공통 메소드의 상수 구현   
J컴포넌트의 주요 메소드 사례   
setground, setOpqque, setFont,등 모양과 관련된 메소드   
Enabled, Visible등 상태와 관련된 메소드   
Width, Height, Location등 위치와 크기에 관련된 메소드   
외에도 컨테이너를 위한 메소드 들이 있다.   
   
예제 10-1
```
package chapter10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JComponentEx extends JFrame {
    public JComponentEx(){
        super("J컴포넌트의 공통 메소드 예제");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton b1 = new JButton("Magenta/Yellow Button");
        JButton b2 = new JButton("  Disabled Button  ");
        JButton b3 = new JButton("get X(), getY()");

        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.MAGENTA);
        b1.setFont(new Font("Arial", Font.ITALIC,20));
        b2.setEnabled(false);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                setTitle(b.getX()+","+b.getY());
            }
        });
        c.add(b1); c.add(b2); c.add(b3);

        setSize(260,200); setVisible(true);
        }
        public static void main(String[] args) {
            new JComponentEx();
        }
}
```   
   
**JLabel**   
레이블 생성 예   
- 문자열 생성   
JLabel textLable = new JLable("사랑합니다");
- 이미지 생성   
ImageIcon image = new ImageIcon("images/sunset.jpg");// 파일로부터 로딩   
JLable imageLable = new JLable(image);   
- 수평 정렬 값을 가진 컴포넌트 생성   
예제 10-2   
```
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

        setSize(300,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LabelEx();
    }
}

```   
   
**JButton**   
용도   
- 사용자로부터 명령을 입력받기위해   
- 버튼은 클릭될때 Action 이벤트 발생   
   
생성   
JButton()   
3개의 이미지 버튼   
normal,rollover,pressed 세종류   
   
예제 10-3   
```
package chapter10;
import javax.swing.*;
import java.awt.*;
public class ButtonImageEx extends JFrame{
    public ButtonImageEx(){
        setTitle("이미지 버튼예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
        ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
        ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");

        JButton btn = new JButton("call~~",normalIcon);
        btn.setPressedIcon(pressedIcon);
        btn.setRolloverIcon(rolloverIcon);
        c.add(btn);

        setSize(250,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ButtonImageEx();
    }
}
```   
   
J체크박스   
체크박스도 만들수 있음, 문자열 체크박스,이미지와 문자열 체크박스 가능   
10-4 예제   
```
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
```   
   
**체크박스에 item 이벤트 처리**   
item 이벤트   
체크박스의 선택 상태에 변화가 생겼을 때 발생하는 이벤트   
사용자가 체크박스를 선택/해제할때   
프로그램에서 체크박스를 선택/해제 하여 체크 상태에 변화가 생겼을 때   
이벤트가 발생시 아이템 이벤트 객체 생성   
   
10-5 예제   
```
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

```   
   
**라디오 버튼 생성 및 item 이벤트 처리**   
버튼 그룹핑을 해주어야함   
1. 라디오 버튼 그룹객체 생성   
2. 라디오 버튼 생성   
3. 라디오 버튼을 버튼그룹에 삽입   
위와같은 방식작동   
10-6 예제   
```
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

```   
   
**JTextField**   
한줄의 문자열을 입력 받는 창을 만들수 있음   
10-7예제   
```
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

```   
   
**JTextArea**   
위의 필드는 1줄, TextArea의 경우 여러줄을 입력받음, JScrollpane에 삽입 해야 스크롤바 지원을 받을수 있음에 유의,   
예제 10-8   
```
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

```   
   
**JList<E>로 리스트만들기**   
사용자에게 하나 이상의 아이템을 보여주고 선택하는 리스트컴포넌트를 생성   
사용자는 하나 이상의 아이템을 선택 가능 아이템은 문자열,이미지 모두 가능   
자체적으로 스크롤을 지원하지않아 ScrollPane 에 삽입하여야 함   
예제 10-9   
```
package chapter10;
import javax.swing.*;
import java.awt.*;

public class ListEx extends JFrame{
    private String[] fruits={"apple","banana","kiwi","mango","pear","peach","berry","strawberry","blackberry"};
    private ImageIcon[]images = {new ImageIcon("images/gosling.jpg"),
    new ImageIcon("images/icon.gif"),new ImageIcon("images/normalIcon.gif"),new ImageIcon("images/rolloverIcon.gif")};

    public ListEx(){
        setTitle("리스트 만들기 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JList<String> strList = new JList<String>(fruits);
        c.add(strList);
        JList<ImageIcon> imageList = new JList<ImageIcon>();
        imageList.setListData(images);
        c.add(imageList);
        JList<String> scrollList = new JList<String>(fruits);
        c.add(new JScrollPane(scrollList));

        setSize(3000,3000);
        setVisible(true);

    }
    public static void main(String[] args) {
        new ListEx();
    }
}
```   
   
**JComboBox<E>로 콤보박스 만들기**   
J콤보박스를 이용하면 텍스트 필드, 버튼,드롭다운리스트로 구성된 콤보박스를 만들 수 있다.   
E대신 아이템의 타입을 대입해서 구체화 해야 한다.   
10-10예제   
```
package chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ComboActionEx extends JFrame{
    private String[] fruits={"apple","banana","mango"};
    private ImageIcon[]images = {new ImageIcon("images/gosling.jpg"),
    new ImageIcon("images/icon.gif"),new ImageIcon("images/normalIcon.gif")};

    private JLabel imgLabel = new JLabel(images[0]);

    public ComboActionEx(){
        setTitle("콤보박스 활용");
        Container c =getContentPane();
        c.setLayout(new FlowLayout());
        JComboBox<String> combo = new JComboBox<String>(fruits);
        c.add(combo); c.add(imgLabel);

        //콤보박스에 액션 리스너 등록, 선택된 아이템의 이미지 출력
        combo.addActionListener(new ActionListener() {
            public void actionPerformed<String>(ActionEvent e){
                JComboBox<String> cb = (JComboBox<String>)e.getSource();

                int index = cb.getSelectedIndex();

                imgLabel.setIcon(images[index]);
            }
        });

        setSize(300,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ComboActionEx();
    }
}

```   
   
**메뉴바**   
10-11예제 메뉴바만들기   
```
package chapter10;
import javax.swing.*;
public class MenuEx extends JFrame{
    public MenuEx(){
        setTitle("메뉴만들기");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createMenu();
        setSize(250,200);
        setVisible(true);
    }
    private void createMenu(){
        JMenuBar mb = new JMenuBar();
        JMenu screenMenu = new JMenu("Screen");

        screenMenu.add(new JMenuItem("Load"));
        screenMenu.add(new JMenuItem("Hide"));
        screenMenu.add(new JMenuItem("ReShow"));
        screenMenu.addSeparator();
        screenMenu.add(new JMenuItem("Exit"));

        mb.add(screenMenu);
        mb.add(new JMenu("Edit"));
        mb.add(new JMenu("Source"));
        mb.add(new JMenu("Project"));
        mb.add(new JMenu("Run"));

        setJMenuBar(mb);
    }
    public static void main(String[] args) {
        new MenuEx();
    }
}

```   
   
**팝업다이얼로그,확인다이얼로그,메시지다이얼로그**   
팝업은 메시지를 전달하거나 입력받을수 있는 팝업창, 확인은확인받기위함, 메시지는 Ok만 누르는 다이얼로그   
10-13 예제   
```
package chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class OptionPaneEx extends JFrame{
    public OptionPaneEx(){
        setTitle("옵션 팬 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        setSize(500,200);
        c.add(new MyPanel(),BorderLayout.NORTH);
        setVisible(true);
    }
    class MyPanel extends Panel{
        private JButton inputBtn = new JButton("Input Name");
        private JTextField tf = new JTextField(10);
        private JButton confirmBtn = new JButton("Confirm");
        private JButton messageBtn = new JButton("Message");
        public MyPanel(){
            setBackground(Color.LIGHT_GRAY);
            add(inputBtn);
            add(confirmBtn);
            add(messageBtn);
            add(tf);

            inputBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String name = JOptionPane.showInputDialog("이름을 입력하세요.");
                    if(name !=null)
                    tf.setText(name);
                }
            });

            confirmBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    int result = JOptionPane.showConfirmDialog(null, "계속?","컨펌",JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.CLOSED_OPTION)
                    tf.setText("Just Closed without Selection");
                    else if(result == JOptionPane.YES_OPTION)
                    tf.setText("yes");
                    else
                    tf.setText("no");
                }
            });
            messageBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "조심", "Message",JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }
    public static void main(String[] args) {
        new OptionPaneEx();
    }

}

```   
   

#### 5월 24일 강의   

**이벤트 기반 프로그래밍(Event Driven Programming)**   
이벤트 발생에 의해 그포그램 흐름이 결정되는 방식   
이벤트가 발생하면 이벤트를 처리하는 루틴 실행   
실행될 코드는 이벤트의 발생에 의해 전적으로 결정   
이벤트 종류   
1. 사용자의 입력 : 마우스드래그 클릭 키보드 누름 등   
2. 센서로부터의 입력, 네트워크로부터 데이터 송수신   
3. 다른 응용 프로그램이나 다른 스레드로부터의 메시지   

##### **이벤트 기반응용 프로그램의 구조**   
각 이벤트마다 처리하는 리스너 코드 보유   
GUI 응용 프로그램은 이벤트 기반프로그래밍으로 작성됨   
GUI 라이브러리 종류   
C++의 MFC ,C#, VISUAL Basic, X window, Android모두 이벤트 기반 GUI 응용프로그램을 작성할 수 있는 패키지나 라이브러리 제공   
자바에선 AWT나 Swing 을 이용하여 GUI 응용프로그램을 작성 할 수 있음   
**이벤트 처리 과정**   
이벤트 발생 예: 마우스 움직임 혹은 키보드입력   
이벤트 객체 생성 : 현재 발생한 이벤트에 대한 정보를 가진 객체   
응용프로그램에 작성된 이벤트 리스너 찾기   
이벤트 리스너 실행   
리스너에 이벤트 객체 전달   
리스너 코드 실행   
**이벤트 관련 용어**   
이벤트 소스 - 이벤트를 발생시킨 GUI컴포넌트   
이벤트 객체 - 발생 이벤트에 대한 여러 정보를 제공하는 객체, 이벤트에 따라 다른 정보 저장   
이벤트 리스너 - 사용자가 작성하며, 이벤트를 처리하는 자바프로그램 코드,클래스로 작성   
이벤트 분배 스레드 - 무한 루프를 돌면서, 이벤트가 발생하면 이벤트 리스너를 찾아 호출하는 스레드, 자바플랫폼에서 제공   
**이벤트 객체**   
발생한 이벤트에 관한 정보를 가진 객체   
이벤트 리스너에 전달함   
이벤트 객체가 포함하는 정보   

1. 이벤트 종류와 이벤트 소스   
2. 이벤트가 발생한 화면 좌표 및 컴포넌트 소스 내 좌표   
3. 이벤트가 발생한 버튼이나 메뉴 아이템들의 문자열   
4. 클릭된 마우스 버튼 번호 및 마우스의 클릭횟수   
5. 키의 코드 값과 문자 값    
6. 체크박스, 라디오 버튼 등과 같은 컴포넌트에 이벤트가 발생하였다면 체크 상태   

**이벤트 소스를 알아 내는 메소드**   
Onject getSource()   
발생한 이벤트의 소스 컴포넌트 리턴   
Object 타입으로 리턴하므로 캐스팅하여 사용   
모든 이벤트 객체에 대해 적용   
**이벤트 리스너**    
이벤트를 저리하는 자바프로그램코드, 클래스로 작성   
자바는 다양한 리스너 인터페이스 제공   
예 : ActionListener 인터페이스   
```
interface ActionListener{
    public void actionPerformd(ActionEvent e); //이벤트 발생처리
}
```   
사용자의 이벤트 리스너 작성 자바의 리스너 인터페이스를 상속받아 구현   
1. **이벤트와 이벤트 리스너 선택**   
이벤트 : Action 이벤트   
이벤트 리스너 : ActionListener   
이벤트 객체 : ActionEvent   
2. **이벤트 리스너 클래스 작성**   
ActionListener 인터페이스를 상속받은 MyActionListener 클래스를 선언후, 추상 메소드 ActionPerformed(ActionEvent e)를 다음과 같이 구현   
```class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action"))
            b.setText("액션");
        else
            b.setText("Action");
    }
}
```   
3. **이벤트 리스너 등록**   
이벤트 리스너가 작동되기 위해서는 MyActionListener클래스의 객체를 버튼 컴포넌트에 등록하여야 한다.
``` MyActionListener listener = new MyActionListener();
    btn.addActionListener(listener);
```   
일반적으로 컴포넌트에 이벤트 리스너를 등록할때 다음과 같이 한다.   
```component.addXXXListener(listener);```
**이벤트 리스너 작성방법**   
독립 클래스    
- 이벤트 리스너를 완전한 클래스로 작성   
- 이벤트 리스너를 여러 곳에서 사용할 때 적합   
내부 클래스 : InnerClassListener.this.setTitle(b.getText())   
- 클래스 안에 멤버처럼 클래스 작성   
- 이벤트 리스너를 특정 클래스에서만 사용할 때 적합   
익명 클래스 : AnnonymousClassListener.this.setTitle(b.getText())   
- 클래스의 이름 없이 간단한 리스너 작성   
- 클래스 조차 만들 필요 없이 리스너 코드가 간단한 경우에 적합   

예제 9-1 독립클래스   
```
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
```
   
예제 9-2 내부클래스   
```
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
```
   
예제 9-3 익명 클래스   
```
package chapter09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnonymouseClassListener extends JFrame{
    public AnonymouseClassListener(){
        setTitle("이벤트리스너 작성");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,120);
        setVisible(true);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        c.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");
            
            setTitle(b.getText());
            }
        });
    }
    public static void main(String[] args) {
        new AnonymouseClassListener();
    }
}

```
   
예제 9-4 마우스 리스너 작성 연습 - 마우스로 문자열 이동   
```package chapter09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseListenerEx extends JFrame{
    private JLabel la =new JLabel("Hello"); // Hello 문자열을 출력하기 위한 레이블

    public MouseListenerEx(){
        setTitle("마우스이벤트 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,200);
        setVisible(true);

        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null);
        la.setSize(50,20);
        la.setLocation(30,30);
        c.add(la);
    }
    class MyMouseListener implements MouseListener{
        public void mousePressed(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
        public void mouseReleased(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
    }
    public static void main(String[] args) {
        new MouseListenerEx();
    }
}
```
   
**어댑터 클래스**   
이벤트 리스너 구현에 따른 부담   
리스너의 추상 메소드를 '모두' 구현해야하는 부담   
어댑터 클래스
- 리스너의 모든 메소드를 단순 리턴하도록 만든 클래스 JDK에서 제공
- ActionListener와 같이 어댑터가 제공되지않는 리스너도 있음(메소드가 하나뿐인 경우)   
예제 9-5   
```
package chapter09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseAdapterEx extends JFrame{
    private JLabel la = new JLabel("Hello");

    public MouseAdapterEx(){
        setTitle("마우스이벤트 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,200);
        setVisible(true);

        Container c = getContentPane();
        c.addMouseListener(new MyMouseAdapter());

        c.setLayout(null);
        la.setSize(50,20);
        la.setLocation(30,30);
        c.add(la);
    }
    class MyMouseAdapter extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x,y);
        }
    }
    public static void main(String[] args) {
        new MouseAdapterEx();
    }
}

```
   
**Key 이벤트와 포커스**   
키 입력시 다음의 세 경우 Key 이벤트 발생   
- 키를 누르는 순간   
- 누른 키를 떼는 순간   
- 누른 키를 떼는 순간(unicode의 경우)   
키 이벤트를 받을 수 있는 조건   
- 모든 컴포넌트   
- 현재 포커스를 가진 컴포넌트가 키 이벤트 독점   
**포커스**   
컴포넌트나 응용 프로그램이 키 이벤트를 독점하는권한   
KeyListener   
응용프로그램에서 KeyListener 상속받아 키 리스너 구현 메소드3개   
- keyPressed()   
- keyTyped()   
- keyReleased()   
**유니코드 키**   
특징   
국제 산업 표준   
전세계 문자를 컴퓨터에서 일관되게 표현하기 위한 코드체계   
문자들에 대해서만 키 코드 값 정의   
문자가 아닌 경우 표준화된 키 코드 값 없음   
유니코드 키가 입력된경우   
key리스너 메소드가 순서대로 호출   
**key 이벤트 객체**   
입력된 키 정보를 가진 이벤트 객체   
객체의 메소드로 입력된 키 판별 
char KeyEvent.getKeyChar()  
키의 유니코드 문자값 리턴   
문자 키인 경우에만 의미있음   
입력된 키를 판별하기 위해 문자값과 비교하면됨   
int Key Event.getKeyCode()
유니코드 키 포함   
모든키에 대한 정수형 키 코드 리턴   
입력된 키를 판별 위해 가상 키값과 비교   
가상 키 값은 KeyEvent 클래스에 상수로 선언   
   
예제 9-6 입력된 문자 키 판별   
```
package chapter09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyCharEx extends JFrame{
    private JLabel la = new JLabel("<Enter>키로 배경색이 바뀝니다.");
    public KeyCharEx(){
        super("KeyListener의 문자 키 입력 예제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(la);
        c.addKeyListener(new MyKeyListener());
        setSize(250,150);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }
    class MyKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int r = (int) (Math.random()*256);
            int g = (int) (Math.random()*256);
            int b = (int) (Math.random()*256);

            switch(e.getKeyChar()){
                case '\n':
                la.setText("r="+ r + ", g=" + g + ", b=" + b);
                getContentPane().setBackground(new Color(r, g, b));

                break;
                case 'q' : System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        new KeyCharEx();
    }
}

```
   
예제 9-7   
```
package chapter09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlyingTextEx extends JFrame{
    private JLabel la = new JLabel("HELLO");

    public FlyingTextEx(){
        super("상하좌우키를 이용해 텍스트 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        c.addKeyListener(new MyKeyListener());
        la.setLocation(50, 50);
        la.setSize(100,20);
        c.add(la);
        setSize(200,200);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    class MyKeyListener extends KeyAdapter{
        public void KeyPressed(KeyEvent e){
            int Keycode = e.getKeyCode();
            switch (Keycode) {
                case KeyEvent.VK_UP:
                    la.setLocation(la.getX(),la.getY() -10);
                    break;
                case KeyEvent.VK_DOWN:
                la.setLocation(la.getX(),la.getY() +10);
                break;
                case KeyEvent.VK_LEFT:
                la.setLocation(la.getX()-10,la.getY());
                break;
                case KeyEvent.VK_RIGHT:
                la.setLocation(la.getX()+10,la.getY());
                break;    
            
            }
        }
    }
    public static void main(String[] args) {
        new FlyingTextEx();
    }
}

```
   
마우스 이벤트 처리 예제   
```
package chapter09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import chapter09.MouseListenerEx.MyMouseListener;

public class MouseEventAllEx extends JFrame{
    private JLabel la = new JLabel("   Move Me");

    public MouseEventAllEx(){
      setTitle("마우스리스너와 모션리스너예제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      
      MyMouseListener listener = new MyMouseListener();
      c.addMouseListener(listener);
      c.addMouseMotionListener(listener);

      c.setLayout(null);

      la.setSize(80,20);
      la.setLocation(100,80);
      c.add(la);

      setSize(320,200);
      setVisible(true);
    }
    class MyMouseListener implements MouseListener,MouseMotionListener{
        public void mousePresssed(MouseEvent e){}
    }
}

```
   
#### 5월 17일 강의
배치관리자 대표 유형 4가지   
**FlowLayout**   
컴포넌트가 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치   
배치할 공간이 없으면 아래로 내려와서 반복   
**BorderLayout**   
컨테이너의 공간을 동서남북중앙 5개의영역으로 나눔   
**GridLayout**   
컨테이너의 공간을 응용프로그램에서 2차원 그리드로 나누고   
컴포넌트가 들어오는 순서대로 좌에서 우로 위에서 아래로 순서대로 배치   
컴포넌트의 크기는 셀의 크기와 일치   
**CardLayout**   
컨테이너의 공간에 카드를 쌓듯이 컴포넌트를 포개어 배치   
컴포넌트의 크기는 컨테이너의 크기와 일치   
컨테이너와 디폴트 배치관리자   
**컨테이너 생성시 자동 생성되는 배치관리자**   
AWT와 스윙컨테이너 디폴트 배치관리자   
Window,Jwindow / BorderLayout   
Frame,JFrame / BorderLayout   
Dialog,JDialog / BorderLayout   
Panel,JPanel / FlowLayout   
Applety,JApplet / FlowLayout   
**컨테이너에 새로운 배치관리자 설정**   
컨테이너에 새 배치관리자 설정   
setLayout()메소드를 호출하여 새로운 배치관리자를 설정할수 있음   
**FlowLayout**배치관리자   
컴포넌트를 컨테이너 내에서 왼쪽에서 오른쪽으로 배치후 다시 위에서 아래로 순서대로 배치   
생성자   FlowLayout()   FlowLayout(int align,int hGap int VGap) 컴포넌트를 정렬하는 방법지정    Gap은 수평(h),수직(v)간격 조정   
``` package chapter08;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
class EX8_3  extends JFrame{
    public EX8_3(){
        setTitle("플로우레이아웃 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane(); //컨텐트팬 알아내기

        //왼쪽정렬로 수평 30 수직 40픽셀 배치 플로우 레이아웃 생성
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));

        contentPane.add(new JButton("add"));
        contentPane.add(new JButton("sub"));
        contentPane.add(new JButton("mul"));
        contentPane.add(new JButton("div"));
        contentPane.add(new JButton("Calculate"));

        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EX8_3();
    }
}

```
BorderLayout   
```package chapter08;

import javax.swing.*;
import java.awt.*;

public class EX8_4 extends JFrame{
    public EX8_4(){
        setTitle("보더레이아웃예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        contentPane.setLayout(new BorderLayout(30,20));

        contentPane.add(new JButton("Calculate"),BorderLayout.CENTER);
        contentPane.add(new JButton("add"),BorderLayout.NORTH);
        contentPane.add(new JButton("sub"),BorderLayout.SOUTH);
        contentPane.add(new JButton("mul"),BorderLayout.EAST);
        contentPane.add(new JButton("div"),BorderLayout.WEST);
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EX8_4();
    }
}
```   
GridLayout   
```package chapter08;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class EX8_5 extends JFrame{
    public EX8_5(){
        super("그리드레이아웃예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contanePane = getContentPane();

        contanePane.setLayout(new GridLayout(1,10));

        for(int i=0;i<10;i++){
            String text = Integer.toString(i);
            JButton button = new JButton(text);
            contanePane.add(button);
        }
        setSize(500,200);
        setVisible(true);
    }   
    public static void main(String[] args) {
        new EX8_5();
    }
}
```   
배치관리자 제거 setLayout(null)으로 제거   
절대위치와 크기설정   
```
void setSize(int width,int height)
void setLocation(int x,int y)
void setBounds(int x,int y,int width,int height)
```
```package chapter08;

import javax.swing.*;
import java.awt.*;
public class EX8_6 extends JFrame{
    public EX8_6(){
        setTitle(" 배치관리자없이 절대위치에 배치하는예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        contentPane.setLayout(null); //컨탠츠팬의 배치관리자 제거

        JLabel la = new JLabel("Hello, Press Buttons!");
        la.setLocation(130,50);
        la.setSize(200,20);
        contentPane.add(la);


        for(int i=1;i<=9;i++){
            JButton b = new JButton(Integer.toString(i));
            b.setLocation(i*15,i*15);
            b.setSize(50,20);
            contentPane.add(b);
        }
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new EX8_6();
    }
}
```   
#### 5월 3일 강의
컬렉션
    element라 불리는 가변 개수의 객체들의 저장소
    객체들을 컨테이너라고도 부름
    요소 개수에 따라 크기 자동조절
    요소의 삽입 삭제에 따른 요소의 위치 자동 이동
    고정크기 배열을 다루는 어려움 해소
    다양한 객체의 삽입,삭제,검색의 관리가 용이
    특징 제네릭기법으로 구현
제네릭
    특정 타입만 다루지않고 여러종류의 타입으로 변신 할수있도록 클래스나 메소드를 일반화 하는기법
    사례: 벡터 <E> E에 구체적인 타입을 주어 구체적 타입만 다루는 벡터로 활용
    정수만 다루면 Integer 문자열만 다루면 String 등을 넣어 활용
    컬렉션 요소는 객체만 가능 (int,char,double 불가능)
    제네릭은 클래스나 메소드를 형판에 찍어내듯 생산할수있도록 형판을 만드는 기법
    JDK 1.5부터 도입 모든 종류의 데이터 타입을 다룰 수 있도록 일반화 된 타입 매개 변수로 클래스,메소드를 작성
    C++의 템플릿과 동일함
벡터의 특성
    요소의 특정 타입으로 구체화
    배열을 가변 크기로 다룰 수 있게 하는 컨테이너
        배열의 길이제한 극복 요소의 개수가 넘치면 자동으로 길이조절
    요소 객체들을 삽입 삭제하는 컨테이너
        삽입 삭제에따라 위치조정
    벡터에 삽입 가능한것
        null,객체
        기본타입의 같은 Wrapper 객체로 만들어 저장 
    벡터에 객체 삽입
        벡터의 맨 뒤, 중간에 객체 삽입가능
    벡터에서 객체 삭제
        임의의 위치에 있는 객체 삭제가능
ArrayList<E>
    벡터와 거의 동일하지만 스레드간에 동기화를 지원하지않아
    다수의 스레드가 동시에 요소를 삽입,추가 할경우 충돌이 발생할수 있다.
Iterator
    리스트 구조의 컬렉션에서 요소의 순차 검색을 위한 인터페이스
GUI
    AWT swing 패키지 지금은 스윙
    GUI 패키지 계층구조 AWT를 버릴순 없음
    컨테이너 다른 컴포넌트를 포함 할수 있는 컴포넌트
    Swing 컨테이너 프레임 패널 에플릿 다이얼로그 윈도우 등
컴포넌트 컨테이너에 포함되어야 화면에 출력할수 있는 GUI객체
    다른 컴포넌트를 포함할 수 없는 순수 컴포넌트
    모든 GUI 컴포넌트가 상속받는 클래스
    스윙 컴포넌트가 상속받는 클래스
    최상위 컨테이너 컨테이너 중 다른 컨테이너에 속하지않고 독립적으로 존재해 출력할 수있는 컨테이너(JFrame,JDialog,JApplet등이 이에 속함)
Swing 프레임
    컨텐츠 팬에 컴포넌트 달기 스윙에서는 컨텐트팬에만 컴포넌트 부착
#### 4월 19일 강의
추상 메소드
abstract 로 선언한 메소드로 메소드의 코드는없고, 원형만 선언한것
추상 클래스 
    추상 메소드를 가지며 abstract 로 선언된 클래스
    추상 메소드 없이 abstract 로 선언한 클래스
    추상클래스를 상속받으면 추상클래스가 됨 서브 클래스도 abstract로 선언해야함
    서브클래스에서 슈퍼클래스의 추상 메소드구현(오버라이딩)
    추상클래스를 구현한 서브 클래스는 추상 클래스가 아님
목적
    상속을 위한 슈퍼클래스로 활용, 서브클래스에서 추상 메소드 구현 다형성 실현
인터페이스
    소프트웨어를 !규격화된 모듈로 만들고 모듈을 조립하듯이 응용프로그램을 작성하기위해! 사용
    클래스가 구현해야 할 메소드들이 선언되는 추상형
    interface 키워드로 선언
    여전히 멤버 변수 선언은 불가능
    7에선 상수, 추상메소드
    8부터 상수, 추상메소드 디포트 프리뱃 스태틱 메소드도 가능
인터페이스는 객체 생성 불가능
상속 가능 상속하여 확장된 인터페이스 작성, extends키워드로 상속선언
implements 키워드 사용
여러개의 인터페이스 동시 구현 가능

오버로딩 라이딩 잘 기억하기

패키지
    서로 다른 패키지에서 같은 이름의 클래스 존재 가능성 O
    서로 다른 디렉터리를 통해 코드 관리
    패키지 서로관련 클래스 인터페이스 컴파일 클래스 파일 묶은 디렉터리
    하나의 응용 프로그램 한개 이상 패키지로 작성
    패키지는 jar 파일로 압축할수 있음
모듈
    여러 패키지와 이미지 등의 자원을 모은 컨테이너
    하나의 모듈을 하나의 .jmod로 저장
자바9 부터 자바API를 여러 모듈로 분할(8까지는 rt.jar 한 파일에 모든API를 저장함)
응용 프로그램이 실행할 때 필요한 모듈들로만 실행 환경 구축
자바9부터 전면적 도입 복잡한 개념
큰 자바 응용프로그램에는 개발,유지보수에 적합
현실적으론 모듈로 나누어 자바 프로그램을 작성할 필요는 없다.
자바가설치된 jmods디렉터리에 모듈 파일 존재
기본 모듈은 base모듈이며 .jmod파일은 집 포맷으로 압축된것으로 jmod프로그램을 이용해 풀수있다.
패키지 사용, import문 사용
    다른 패키지에 작성된 클래스 사용
    필요한 클래스만 import 소스 시작부분 클래스의 경로명 import 임포트 패키지.클래스 소스엔 클래스 명만 명시하면 됨
    패키지 전체 import 임포트 패키지.* 소스엔 클래스 명만 명시 하면 됨
클래스 파일 저장 위치
    클래스나 인터페이스 컴파일시 클래스 파일 생성
    클래스 파일 패키지 선언된 디렉터리 저장
패키지 선언 소스파일 맨 앞 컴파일 후 저장될 패키지 지정

생성자 오버로딩 오버라이딩 패키지
#### 4월 19일 강의
추상클래스 인터페이스내용이 날아감
오버로드 라이딩 중요함
객체 속성 Object클래스는 객체 속성 나타내는 메소드 제공
객체 비교와 equals 메소드
==연산자는 객체의 레퍼런스를 비교 equals 메소드는 두 객체의 내용을 비교
객체의 내용물을 비교하기 위해 클래스 멤버로 작성
Wrapper 클래스
    자바 기본타입을 클래스화 한 8개의 클래스를 통칭 앞글자 대문자
    용도 : 객체만 사용할 수 있는 컬렉션 등에 기본 타입의 값을 사용하기 위해 객체로 만들어 사용
    기본타입으로 객체생성, 캐릭터 제외 문자열로 생성, Float 객체는 더블 타입으로도 생성가능
박싱,언박싱 기본타입을 랩퍼 객체로 변환하는걸 박싱,반대의 경우를 언박싱이라 한다
String 클래스는 문자열을 나타냄
스트링 리터럴 JVM 내부에서 리터럴 테이블에 저장,관리
new String()으로 생성된 스트링
스트링 객체는 힙에 생성 스트링은 공유X
스트링 객체는 수정 불가능 스트링 비교엔 ==사용하지않으며 equals 를 사용한다.
MATH 클래스
기본 산술 연산 메소드 제공 클래스
모든 메소드 static 선언
1,2,3 꼭알아야함 중간고사 수요일 10:00
코드 완성 오류 수정 문제

#### 4월 12일 강의
스태틱 메소드의 제약 조건
오직 스태틱 멤버만 접근가능
    예시 : 스태틱 메소드는 논스태틱 메소드 필드의 메소드나 변수 사용불가능(스태틱은 생성전부터 존재하기때문에 생성될때 만들어지는 논스태틱 사용불가능)
스태틱 메소드는 this 사용불가능
    예시 : 스태틱 메소드는 객체와 상관없이 존재하기때문에 this 래퍼런스 사용 불가능

final 키워드
메소드 앞에 final 이 붙을 경우 오버라이딩 불가능
필드 앞에 final 이 붙을 경우 필드는 상수가 된다(변경 불가능)
public static과 함께 선언할경우 프로그램 전체에서 공유 할수있음

상속
상속의 필요성
    상속없이 동일 코드가 여러 클래스에 중복될 경우 클래스 유지보수를 하기힘들게 된다(4개의 클래스에 공통된 1개의 메소드가 문제가 있으면4번고쳐야함)
    상속을 이용하면 중복된 클래스의 동일코드 하나를 상속시켜 한번만 고치면됨
상속의 장점
    클래스 사이의 멤버 중복선언 불필요 - 클래스의 간결화
    클래스들의 계층적 분류로 - 관리 용이
    클래스 재사용과 확장을 통한 - 생산성향상
상속의 선언
    extends 키워드로 선언
    부모 클래스(슈퍼)
    자식 클래스(서브)
    상속받을 경우 부모클래스의 메소드를 다시 선언할 필요가없고, 필요한 필드나 메소드를 추가 선언하면된다.
서브클래스 객체의 모양
    슈퍼클래스 객체와 서브 클래스 객체는 별개
    서브 클래스 객체는 슈퍼클래스의 멤버 포함
클래스 다중상속 불가능
인터페이스는 다중상속

슈퍼클래스 private 멤버 서브클래스에서 접근x
default 동일 패키지일때 접근가능
public 항상가능
protected 같은패키지의 모든 클래스 허용
패키지 여부 상관없이 서브는 가능
상속과 생성자
서브 클래스 객체 생성시 서브와 슈퍼 둘다 실행됨
서브클래스와 슈퍼클래스 생성자가 실행될때 슈퍼클래스가 먼저 실행됨

업캐스팅 개념
서브 클래스의 래퍼런스를 슈퍼클래스 래퍼런스에 대입
슈퍼클래스 래퍼런스로 서브클래스 객체를 가리키게 되는 현상

다운캐스팅
슈퍼클래스 래퍼런스를 서브 클래스 래퍼런스에 대입
업캐스팅된 것을 다시 원래대로 되돌리는 것
반드시 명시적 타입 변환을 지정
업캐스팅된 래퍼런스로는 객체 실제 타입을 구별하기 어려움
래퍼런스가 가리키는 객체의 타입을 구분하기 위해 instanceof 연산자를 사용
예)
class Person{}
class Researcher extends Person
class Professor extends Researcher
person p = new professor();
if(p instanceof Person) //true
if(p instanceof Student) // false Student 를 상속x
if(p instanceof Researcher) true
if(p instanceof Professor) true
메소드 오버라이딩의 개념
서브클래스 에서 슈퍼 클래스에 선언된 메소드를 중복 작성해서
슈퍼클래스의 메소드를 무력화하고 객체의 주인이되는것으로
슈퍼클래스 래퍼런스든 서브클래스 래퍼런스든 오버라이딩한 메소드가 실행됨
서브클래스에 오버라이딩한 메소드는 반드시 슈퍼클래스에 작성된 이름 리턴타입 매개변수 리스트가 모두 같게 작성되어야한다.
오버라이딩의 목적은 다형성 실현에 있다.
상속을 통해 하나의 인터페이스로 서로 다른 내용 구현을 실현하는 도구
동적 바인딩은 실행할 메소드를컴파일시 결정하는것이 아닌 실행시 결정하는것을 말한다 
super 키워드로 슈퍼클래스의 멤버접근(서브클래스에서만 가능)
super를 사용하면 정적바인딩이됨(오버라이딩이 되어있어도 그대로 불러옴)
super.슈퍼클래스의멤버
오버로딩과 오버라이딩
오버라이딩은 슈퍼클래스에 있는 메소드 이름 변수타입 개수 리턴타입들이 모두 동일한 메소드가 서브클래스에 재정의 됬을경우
오버로딩은 하나의 클래스나 상속관꼐에 있는 클래스에 매개변수 타입이나 개수가 다른 여러 메소드가 같은이름으로 작성되는경우를 지칭

추상메소드는 abstract 키워드와 함께 원형만 선언되고 코드가 작성되지않은 메소드이다
#### 4월 5일 강의
2차원 배열
메소드의 배열 리턴
예외 처리
예외(exception)
실행중 오동작이나 결과에 악영향을 미치는 예상치 못한 상황 발생시
정수를 0으로 나누는 경우
배열의 크기보다 큰 인덱스로 배열의 원소를 접근하는경우
정수를 읽는 코드가 실행되고있을때 사용자가 문자를입력한 경우
try(예외가 발생할 가능성이있는 실행문) catch(처리할 예외타입 선언 후 예외처리문 작성) finally(생략가능)문
예외가 발생할 가능성이 있는 실행문을 try블록에 묶고 예외처리 코드를 catch블록에 작성 catch 블록은 예외마다 하나씩 작성되어야함


4장 클래스와 객체
실세계 객체의 특징
1. 객체마다 고유한 특성과 행동을 가짐
2. 다른 객체들과 정보를 주고 받는 등 상호작용하면서 살아감
예) 붕어빵 틀 = 클래스 붕어빵 = 객체

컴퓨터 프로그램에서 객체 사례
테트리스 게임의 각 블록
한글 프로그램의 메뉴나 버튼들

자바 객체지향의 특성
1. 캡슐화 : 외부의 접근으로 부터 객체 보호
2. 상속 : 자바에서 상속은 자식클래스가 부모클래스의 속성을 물려받아
    부모 클래스에 기능을 확장(extends)하는 개념, 부모클래스를 super class 자식 클래스를 sub class 라고 부른다.
3. 다형성 : 같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 구현되는것을 말함 
    자신의 특징에 맞게 동일 이름으로 다르게 구현하는것을 메소드 오버라이딩(overriding)으로 부른다 다른 사례로는
    클래스 내에서 같은 이름의 메소드를 여러 개 만드는 메소드 오버 로딩(overroading)이 있다. 매개변수가 다르거나 변수 갯수가 다르거나
객체 지향 언어의 목적
컴퓨터 산업의 발전에 따른 LC가 짧아져 빠른시간내에 새 소프트웨어를 만들어야했고, 생산성의 향상을 위해 사용하게됨

절차 지향
    흐름도 설계 동작을 함수로 작성 일련의 동작이 순서대로 실행
객체 지향
    물체를 객체로 표현 이들 사이의 관계 상호 작용을 프로그램으로 나타냄
    객체를 추를하고 관계를 결정하며 상호작용에 필요한 함수와 변수를 설계 및 구현
클래스
    객체의 속성과 행위 선언
    객체의 설계도 혹은 틀
    class 키워드로 선언
    멤버 : 클래스 구성 요소 (필드(객체의 상태 값 저장 변수)와 메소드(실행 가능한 함수로 행위를 구현))
    클래스에 대한 public 권한 지정 다른클래스에서 마음대로 호출,접근가능
    클래스 외부에 필드나 메소드를 둘 수 없음

객체
    클래스의 틀로 찍어낸 실체
    프로그램 실행중 생성되는 실체
    메모리 공간을 갖는 구체적인 실체
    인스턴스라고도 부름
생성자
    객체가 생성될 때 초기화 목적으로 실행되는 메소드
    이름은 클래스 이름과 동일 생성자는 여러개 작성가능
    객체 생성시 한번만 호출
    리턴 타입 지정불가능
    기본 생성자 매개변수 없고 아무것도 하지않는 생성자로
    클래스에 생성자가 하나도 선언되어 있지 않을때(초기화 시켜줄필요없을때)
    기본 생성자를 컴파일러가 자동으로 생성함
this 래퍼런스
    객체 자신에 대한 래퍼런스
    this 멤버 형태로 멤버를 접근할때 사용 컴파일러에 의해 자동으로 관리됨    
    this 는 static 메소드에서는 사용불가능
    this() 는 클래스 내에서 다른 생성자를 호출할때 사용 생성자 내에서만 사용가능 코드의 제일처음에있어야함
메소드
    형식 접근지정자(public,private) 리턴타입(int,string) 메소드 이름 매개변수(int i String t) 메소드코드
    기본타입의 값이 전달되는경우 매개변수 m에 지역변수n의 값을 받아옴(n의 값을 바꾸지는 못함)
    객체가 전달되는경우 객체에 대한 레퍼런스가 전달되어 메소드가 종료된 후에도 그대로 남지만, 객체가 통째로 복사되지는않는다
    배열이 전달되는경우 배열에 대한 레퍼런스만 전달된다
메소드 오버로딩
    메소드 이름이 동일해야함 매개변수의 개수나 타입이 달라야함
    메소드의 리턴타입이나 접근지정자는 오버로딩과 관련없다.
객체 치환
    객체 치환시 발생하는 가비지 가비지는 자동으로 수거됨(c는 개발자가 해야함)
    객체 치환은 객체 복사가 아닌 것을 유의해야한다 
객체 소멸 new 에 의해 할당 받은 객체와 배열메모리를 JVM이 되돌려 주는행위
    소멸된 객체 공간은 가용메모리에 포함
    자바에서는 사용자 임의로 객체 소멸X
    자바는 객체 소멸 연산자가 없음
    객체 소멸은 JVM의 고유 역할
가비지 컬렉션
    JVM 이 가비지 자동회수
    가용 메모리 공간이 일정이하로 내려가면 가비지 수거 메모리 공간 확보
    가비지 컬렉터에 의해 자동수행
gc 메소드를 호출 해 가비지 컬렉션 작동을 "요청" 할수있음

패키지
    상호 관련있는 클래스 파일을 패키지에 저장하여 관리
접근 지정자
    private,protected,public,default 4가지
접근지정자 목적
    클래스나 일부 멤버를 공개하여 다른 클래스에서 접근하도록 허용
    객체 지향언어의 캡슐화 정책을 멤버를 보호하는 것
            private default protected pubilc 오른쪽일수록 열려있음
같은패키지 클래스 X O O O
다른패키지 클래스 X X X O
접근가능영역 클래스내 동일패키지 동일패키지와자식클래스 모든클래스
static 멤버
    클래스의 멤버중 static 지시어로 선언된멤버
    객체툴에 의해 공유됨
    클래스 이름으로 접근 가능
    객체의 멤버로 접근 가능
    논스태틱 멤버는 클래스 이름으로 접근 안 됨
### 3월 29일 강의
스캐너와 연산자등 자바 기본프로그래밍
## 3월 22일 강의
자바의 특성

플랫폼 독립성
하드웨어, 운영체제에 종속되지 않는 바이트 코드로 플랫폼 독립성

객체지향
캡슐화, 상속, 다형성 지원

클래스로 캡슐화
자바의 모든 변수나 함수는 클래스 내에 선언
클래스 안에서 클래스(내부 클래스) 작성 가능

소스(.java)와 클래스(.class) 파일
하나의 소스 파일에 여러 클래스를 작성 가능

public 클래스는 하나만 가능
소스 파일의 이름과 public으로 선언된 클래스 이름은 같아야 함
클래스 파일에는 하나의 클래스만 존재 다수의 클래스를 가진 자바 소스를 컴파일하면 클래스마다 별도 클래스 파일 생성


자바의 특징
실행 코드 배포

구성
한 개의 class 파일 또는 다수의 class 파일로 구성
여러 폴더에 걸쳐 다수의 클래스 파일로 구성된 경우 : jar 압축 파일로 배포

자바 응용프로그램의 실행은 main() 메소드에서 시작
하나의 클래스 파일에 두 개 이상의 main() 메소드가 있을 수 없음
각 클래스 파일이 main() 메소드를 포함하는 것은 상관없음

패키지
서로 관련 있는 여러 클래스를 패키지로 묶어 관리
패키지는 폴더 개념
예) java.lang.System은 java\lang 디렉터리의 System.class 파일

멀티스레드
여러 스레드의 동시 수행 환경 지원
자바는 운영체제의 도움 없이 자체적으로 멀티스레드 지원
C/C++ 프로그램은 멀티스레드를 위해 운영체제 API를 호출

가비지 컬렉션
자바 언어는 메모리 할당 기능은 있어도 메모리 반환 기능 없음
사용하지 않는 메모리는 자바 가상 기계에 의해 자동 반환 – 가비지 컬렉션

실시간 응용프로그램에 부적합
실행 도중 예측할 수 없는 시점에 가비지 컬렉션 실행 때문
응용프로그램의 일시적 중단 발생

자바 프로그램은 안전
타입 체크 엄격
물리적 주소를 사용하는 포인터 개념 없음

프로그램 작성 쉬움
포인터 개념이 없음
동적 메모리 반환 하지 않음
다양한 라이브러리 지원

실행 속도 개선을 위한 JIT 컴파일러 사용
자바는 바이트 코드를 인터프리터 방식으로 실행
기계어가 실행되는 것보다 느림
JIT 컴파일 기법으로 실행 속도 개선
JIT 컴파일 - 실행 중에 바이트 코드를 기계어 코드로 컴파일하여 기계어를 실행하는 기법
## 3월 15일 강의
내용 정리