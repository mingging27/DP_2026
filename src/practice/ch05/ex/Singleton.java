package practice.ch05.ex;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("인스턴스를 생성했습니다.");
        slowdown(); // 생성 시간이 오래 걸리도록 함
    }

    public static Singleton getInstance() {
        if (singleton == null) {    // 처음 호출될 때만 객체가 만들어짐
            singleton = new Singleton();
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000); // CPU를 내놓고 1초간 쉰다. 
        } catch (InterruptedException e) {
        }
    }
}
