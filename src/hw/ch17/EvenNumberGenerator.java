package hw.ch17;

public class EvenNumberGenerator extends NumberGenerator {
    private int number;	// 현재 수 
    private int end;		// 종료값 (포함 X)

    public EvenNumberGenerator(int start, int end) {
        if (start % 2 != 0) {
            start++;
        }
        this.number = start;
        this.end = end;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        while (number < end) {
            notifyObservers();
            number += 2;
        }
    }
    
}
