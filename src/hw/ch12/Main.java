package hw.ch12;

public class Main {
    public static void main(String[] args) {
        System.err.println("20230949 박민주");

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("Hello, Java!");
        md.add("Decorator Pattern");
        md.add("is powerful.");

        System.err.println();
        Display d1 = new NumberedBorder(md);
        d1.show();

        System.err.println();
        Display d2 = new FullBorder(new NumberedBorder(md));
        d2.show();

        System.err.println();
        Display d3 = new SideBorder(new NumberedBorder(new FullBorder(md)), '*');
        d3.show();
    }
}
