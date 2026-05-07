package practice.ch17;

public class Main {
    public static void main(String[] args) {
        // 관찰 대상 설정
        RandomNumberGenerator generator = new RandomNumberGenerator();

        // 관찰자 생성
        DigitObserver observer1 = new DigitObserver();
        GraphObserver observer2 = new GraphObserver();

        // 관찰 대상에 관찰자 등록
        generator.addObserver(observer1);
        generator.addObserver(observer2);

        // 관찰 대상 실행
        generator.execute();
    }
}
