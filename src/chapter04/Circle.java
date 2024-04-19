public class Circle {
    int radius;
    String name;

public Circle(){
    radius = 1; name="";
}
public Circle(int r, String n){
    radius = r; name=n;
}
public double getArea(){
    return 3.14*radius*radius;
}
public static void main(String[] args) {
    Circle pizza = new Circle(10,"자바피자");
    Circle donut = new Circle();
    double area = pizza.getArea();
    System.out.println("피자의 면적은" +area);
    area = donut.getArea();
    donut.name = "도넛피자";
    System.out.println(donut.name +"의면적은" + area);
    }
}