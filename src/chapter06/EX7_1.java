package chapter06;
import java.util.Vector;
public class EX7_1 {
public static void main(String[] args) {
    Vector<Integer> v = new Vector<Integer>();
    v.add(5); //벡터에 정수값 5 삽입
    v.add(4);
    v.add(-1);

    v.add(2,100);

    System.out.println("벡터 내의 요소 객체 수 : "+v.size());
    System.out.println("벡터의 현재 용량 : " + v.capacity());

    for(int i =0;i<v.size();i++){
        int n  = v.get(i); //벡터의 i번째 정수를 n에 대입
        System.out.println(n); // 벡터의 i번째 정수 출력
    }
    int sum=0;
    for(int i =0;i<v.size();i++){
        int n = v.elementAt(i);
        sum += n; //벡터내의 정수 합
        }
        System.out.println("벡터 내의 정수 합 : "+ sum);
    }
}