package hw.ch12;

public class NumberedBorder extends Border {
    private int number;  // 번호

    public NumberedBorder(Display display) {
        super(display);
        this.number = 0;
    }
    
    @Override
    public int getColumns() {
        return 4 + display.getColumns();
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return String.format("%2d| ", 1+number++) + display.getRowText(row);
    }
}