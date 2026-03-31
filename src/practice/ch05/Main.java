package practice.ch05;

public class Main {
    public static void main(String[] args) {
        // Singleton s1 = new Singleton(); // 컴파일 에러: 생성자가 private이므로 외부에서 객체 생성 불가
       Singleton.getInstance(); // 정적 메소드를 통해 객체 얻기     
       Singleton2.INSTANCE.hello();

       for (int i = 0; i < 10; i++) {
           System.out.println(TicketMaker.getInstance().getNextTicketNumber());
           System.err.println(TicketMaker.getInstance());
       }

       Triple a1 = Triple.getInstance("ALPHA");
       Triple a2 = Triple.getInstance("ALPHA");
       System.out.println(a1 == a2); // true

       Triple b1 = Triple.getInstance("BETA");
       Triple b2 = Triple.getInstance("BETA");  
       System.out.println(b1 == b2); // true

       Triple g1 = Triple.getInstance("GAMMA");
       Triple g2 = Triple.getInstance("GAMMA");
       System.out.println(g1 == g2); // true

    }
}
