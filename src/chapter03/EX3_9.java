public class EX3_9 {
    public static void main(String[] args) {
        int[] foo ={1,2,3,4,5,};
        int sum=0;
        for(int k:foo){
        System.out.print(k+" ");
        sum +=k;
        }
        System.out.println("합은 "+sum);

        String bar[] = {"사과","배","바나나","체리","딸기","포도"};
        for(String s:bar)
        System.out.print(s+" ");
    }

}
