import java.util.Scanner;

public class EX3_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("exit를 입력시 종료합니다.");
        while (true) {
            System.out.print(">>");
            String text = scanner.nextLine();
            if(text.equals("exit"))
            break;
        }
        System.out.println("종료합니다.");
        scanner.close();
    }
}
