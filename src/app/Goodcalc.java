package app;
import test.Calc;
public class Goodcalc extends Calc{
    public int add(int a,int b){
        return a+b;
    }
    public int substract(int a,int b){
        return a-b;
    }
    public double average(int[] a){
        double sum = 0;
        for(int i=0; i<a.length;i++)
        sum += a[i];
        return sum/a.length;
    }
    public static void main(String[] args) {
        Calc t = new Goodcalc(); 
        System.out.println(t.add(2,3));
        System.out.println(t.substract(2,3));
        System.out.println(t.average(new int []{2,3,4}));
    }
}
