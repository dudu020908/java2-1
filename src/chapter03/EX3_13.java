package chapter03;
import java.util.Scanner;

public class EX3_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend; //나뉨수
        int divisor; //나눗수
        
        System.out.print("나뉨수를 입력하시오:");
        dividend = scanner.nextInt();//나뉨수 입력받기
        System.out.print("나눗수를 입력하시오:");
        divisor = scanner.nextInt();

        try{
            System.out.println(dividend + "를"+ divisor+"로 나누면 몫은"+ dividend/divisor+ "입니다."); //나뉨수를 나눗수로 나눈 몫 출력 코드
        }
        catch(ArithmeticException e){
            System.out.println("0으로는 나눌수 없습니다."); //예외발생시 처리코드(0으로 나누면 예외발생)
        }
        finally{
            scanner.close(); //최종적으로는 스캐너를 종료한다.(예외든 정상적이든)
        }
    }
}
