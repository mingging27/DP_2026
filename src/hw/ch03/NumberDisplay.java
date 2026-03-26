package hw.ch03;

public class NumberDisplay extends AbstractDisplay {
    private int number; // 표시해야 하는 숫자

    // 생성자 
    public NumberDisplay(int number, int repeatCount) {
        super(repeatCount);
        this.number = number;
    }

    @Override
    public void open() {
        System.out.println("<<Number>>");
    }

    @Override
    public void print() {
        // 필드에 기억해 둔 숫자를 1회 표시한다 
        System.out.println(number);
    }

    @Override
    public void close() {
        System.out.println("<<Number>>");
    }
}
