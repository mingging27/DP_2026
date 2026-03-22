package practice.ch02.deligation;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintBannerAdaptor02("Hello World");
        print.printWeak();
        print.printStrong();
       // ((PrintBannerAdaptor02)print).getString(); // .의 우선순위가 (형변환)보다 높기 때문에 괄호 주의
    }
}