package hw.ch20;

public class Main {

    static final String RED= "[31m";
    static final String GREEN = "[32m";
    static final String YELLOW = "[33m";    
    static final String BLUE = "[34m";
    static final String MAGENTA = "[35m";
    static final String CYAN = "[36m";
    static final String RESET = "[0m";

    public static void main(String[] args) {
        System.out.println("20230949 박민주");

        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        String[] colors = {RED, BLUE, GREEN, MAGENTA, CYAN, YELLOW, BLUE};

        BigString bs;
        bs = new BigString(args[0], true);      // 공유한다 
        bs.print(colors);
    }
}
