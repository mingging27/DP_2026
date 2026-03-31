package practice.ch05;

// 싱글톤 패턴 적용하기
public class Singleton {
    // (3) Singleton 객체를 미리 하나 만들어서 static 변수에 저장해 둔다.
    private static Singleton s1 = new Singleton(); // 클래스 로드 시 실행 -> 객체가 하나 만들어짐

    // (1) 생성자를 private로 한다.
    private Singleton() {
        System.out.println("Singleton 객체가 생성됩니다.");
    }

    // (2) Singleton 객체를 얻어가는 static 메소드를 정의한다.
    public static Singleton getInstance() {
        return s1;
    }

}
