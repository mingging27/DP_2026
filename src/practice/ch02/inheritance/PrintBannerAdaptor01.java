package practice.ch02.inheritance;

// 어댑터 (타겟 인터페이스를) : Banner 상송 , Print 인터페이스 구현
public class PrintBannerAdaptor01 extends Banner implements Print {
    // 1. 인자가 없는 생성자는 자동으로 만들어짐
    // 2. 생성자는 상속 X
    public PrintBannerAdaptor01(String string) {
        super(string);    // 부모의 생성자 호출
    }

    @Override
    public void printWeak() {
        showWithParen();    //앞에 객체 이름 없으면 this. 생략인 것
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}