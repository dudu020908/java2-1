package chapter04;

public class EX4_5 {
    String title;
    String author;

    void show(){ System.out.println(title+ " "+author); }
    public EX4_5(){
        this("","");
        System.out.println("생성자 호출됨");
    }
    public EX4_5(String title){
        this(title,"작자미상");
    }
    public EX4_5(String title,String author){
        this.title = title;
        this.author = author;
    }
    public static void main(String [] args){
        EX4_5 littlePrince = new EX4_5("어린왕자","생택쥐페리");
        EX4_5 lovestory = new EX4_5("춘향전");
        EX4_5 emptybook = new EX4_5();
        lovestory.show();
        littlePrince.show();
        emptybook.show();
    }
}
