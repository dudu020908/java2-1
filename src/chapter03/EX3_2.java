import java.util.Scanner;

public class EX3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0,n=0;
        double sum=0;
        System.out.println("정수를 입력하고 마지막엔 0을입력하세요");
        while ((n=scanner.nextInt())!=0) {
            sum = sum +n;
            count++;
        }
        System.out.print("수의 개수는"+count+"개이며");
        System.out.println("평균은"+sum/count+"개입니다.");
        scanner.close();
    }
}
