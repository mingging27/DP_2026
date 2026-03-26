package hw.ch03;

public class Main {
    public static void main(String[] args) {
        System.out.println("20230949 박민주");

        // // 기존 코드 호환성 확인
        // AbstractDisplay d1 = new CharDisplay('H');
        // AbstractDisplay d2 = new StringDisplay("Hello, world.");
        // d1.display();   // default 5회
        // d2.display();   // default 5회
        
        // 반복 횟수 제어
        // AbstractDisplay d1 = new CharDisplay(3, 'H');
        // AbstractDisplay d2 = new StringDisplay(3, "Hello, world.");
        // d1.display();
        // d2.display();
        
        // // 새로운 Display
        AbstractDisplay num = new NumberDisplay(7, 3);
        num.display();
    }
}
