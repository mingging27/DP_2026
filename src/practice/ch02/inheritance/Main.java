package practice.ch02.inheritance;

//이미 제공되는 클래스, Vendor 클래스, 수정 X
public class Main {
    public static void main(String[] args) {
        Banner banner = new Banner("Hello World");
        banner.showWithParen();
        banner.showWithAster();
    
        // 어댑터 사용
        System.out.println("어댑터 사용");
        Print print = new PrintBannerAdaptor01("Hello World");
        print.printWeak();
        print.printStrong();
    }
}