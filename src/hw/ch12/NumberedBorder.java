package hw.ch12;

public class NumberedBorder extends Border {
    public NumberedBorder(Display display) {
        super(display);
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
        return String.format("%2d| ", 1+row) + display.getRowText(row);
    }
}