package chapter03;

import java.util.Scanner;

public class EX3_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("5개의 정수를 입력하세요");
        int intArray[] = new int[5];//5의 크기를 가진 배열의 선언및생성
        double sum=0.0;
        for(int i=0;i<intArray.length;i++) //intArray의 크기(5)만큼 반복하는 반복문
        intArray[i]=scanner.nextInt(); //배열에 입력값 삽입

        for(int i=0;i<intArray.length;i++)
        sum += intArray[i];

        System.out.print("평균은"+ sum/intArray.length);

        scanner.close();
    }
}
