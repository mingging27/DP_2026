package practice.ch03;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay d = new CharDisplay('H'); // 'H': char, "H": 문자열
        d.display();    // 부모로부터 물려받은 display() 메소드 호출 / open() -> print() * 5 -> close()
    
        d = new StringDisplay("Hello, world.");
        d.display();
    }
}
