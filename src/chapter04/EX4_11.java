
class Calc{
    int foo;
    static int bar;

    public static int abs(int a){return a>0 ? a:-a;}
    public static int max(int a ,int b){return(a>b)?a:b;}
    public static int min(int a ,int b){return(a>b)?b:a;}
}
public class EX4_11 {
    public static void main(String[] args) {
        System.out.println(Calc.abs(-5));
        System.out.println(Calc.max(10,8));
        System.out.println(Calc.min(-3,-8));
        Calc a = new Calc();
        Calc.bar = 4;
        a.foo = 10;

        System.out.println(Calc.bar);
        System.out.println(a.foo);
    }
}