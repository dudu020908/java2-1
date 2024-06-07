package chapter12;

public class ThreadMainEx {
    public static void main(String[] args) {
        long id=Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        Thread.State s = Thread.currentThread().getState();

        System.out.println("현재스레드이름 = "+name);
        System.out.println("현재스레드ID = "+id);
        System.out.println("현재스레드우선순위값 = "+priority);
        System.out.println("현재스레드상태 = "+s);
    }
}
