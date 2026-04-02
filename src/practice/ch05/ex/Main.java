package practice.ch05.ex;

public class Main extends Thread {
    public static void main(String[] args) {
        // 스레드를 2개 만듦
        Thread t1 = new Main("Thread-1"); // 스레드 객체 생성
        Thread t2 = new Main("Thread-2"); // 스레드 객체 생성
        
        // 스레드 실행
        t1.start(); // 스레드 실행
        t2.start(); // 스레드 실행
    }

    @Override
    // Thread 클래스의 run() 메서드를 오버라이드함
    // 이 스레드가 실행할 코드
    public void run() {
        Singleton s = Singleton.getInstance();  // 싱글톤 인스턴스를 얻음
        System.out.println(getName() + " : " + s); // 인스턴스의 참조값 출력
    }

    public Main(String name) {
        super(name); // Thread 클래스의 생성자 호출하여 스레드 이름 설정
    }
}
