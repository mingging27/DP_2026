package practice.ch03;

// 부모

public abstract class AbstractDisplay {
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드 
    protected abstract void open();
    protected abstract void print();
    protected abstract void close();

    // display는 AbstractDisplay에서 구현하는 메소드 
    // 큰 틀을 제공하는 메소드 => 템플릿 메소드
    public final void display() {   // final: 하위 클래스에서 오버라이드할 수 없다 (큰 흐름 변경 X)
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
