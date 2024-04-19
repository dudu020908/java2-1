import java.util.Scanner;

public class EX3_7 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int foo[];
        foo = new int[5];
        int max = 0;//가장큰수
        System.out.println("정수 5개를 입력하시오");
        for(int i=0;i<5;i++){
            foo[i]=scanner.nextInt();
            if (foo[i]>max) {
                max=foo[i];
            }
        }
        for(int j=0;j<5;j++)
        System.out.println("인덱스"+j+"에는"+foo[j]+"가 들어있고");
        System.out.println("가장 큰 수는"+max+"입니다.");
        scanner.close();
    }
}
