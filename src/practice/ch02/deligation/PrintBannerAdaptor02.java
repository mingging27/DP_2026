package practice.ch02.deligation;

// 어뎁터
// 자바에서는 다중 상속이 불가능함 (부모가 둘 이상은 허용이 안 됨)
public class PrintBannerAdaptor02 extends Print {
    private Banner banner; // Banner 클래스의 인스턴스를 참조

    public PrintBannerAdaptor02(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen(); // Banner 클래스의 메서드를 호출 -> delegation (위임)
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }

    public String getString() {
        return "홍길동";
    }
}