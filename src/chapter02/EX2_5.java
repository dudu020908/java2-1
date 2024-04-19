package chapter02;
import java.util.Scanner;
public class EX2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("당신의 이름은"+ name + "입니다.");
        int age = scanner.nextInt();
        System.out.println("당신의 나이는"+ age + "입니다.");
        scanner.close();
    }
}
