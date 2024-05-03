package chapter06;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class EX7_5 {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<String,String>(); // 영단어와 한글단어의 쌍을 저장하는 HashMap 컬렉션을 생성

        dic.put("baby", "아기"); //baby는 Key 아기는 Value
        dic.put("love", "사랑");
        dic.put("apple", "사과");

        Set<String> Keys = dic.keySet(); //모든 키를 Set컬렉션에 받아옴
        Iterator<String> it = Keys.iterator();//Set에 접근하는 Iterator 를 리턴
        while (it.hasNext()) {
            String key = it.next(); //키
            String value = dic.get(key); // 값
            System.out.println("("+key+"," +value+")");
        }
        System.out.println();
        //영단어 입력받고 한글단어 검색해 출력
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<3;i++){
            System.out.println("찾고 싶은 단어는? : ");
            String eng = scanner.next();// 해시맵에서 키 eng 의 값인 kor 검색
            String kor = dic.get(eng);
            if(kor ==null) System.out.println(eng+"는 없는 단어입니다.");
            else System.out.println(kor);
        
            scanner.close();
        }
    }
}
