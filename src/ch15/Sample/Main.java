package ch15.Sample;

import ch15.Sample.pagemaker.PageMaker;

public class Main {
    // 퍼사드 이용
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@example.com", "welcome.html");
    }
}
