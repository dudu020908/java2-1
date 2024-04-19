
public class EX4_4 {
    String title;
    String author;
    public EX4_4(){
        title = "해리포터";
        author = "모름";
    }
    public EX4_4(String t){
        title = t;
        author = "작자미상";
    }
    public EX4_4(String t,String a){
        title = t;
        author = a;
    }
    public static void main(String [] args){
        EX4_4 littlePrince = new EX4_4("어린왕자","생택쥐페리");
        EX4_4 lovestory = new EX4_4("춘향전");
        EX4_4 foo = new EX4_4();
        System.out.println(littlePrince.title+ " "+ littlePrince.author);
        System.out.println(lovestory.title+ " "+lovestory.author);
        System.out.println(foo.title +" "+ foo.author);
    }
}
