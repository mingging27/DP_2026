package hw.ch17;

public class RandomObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("RandomObserver:");
        int count = generator.getNumber();

        if (count < 10 && count >= 0) {
            System.out.println("Low");
        } else if (count < 20 && count >= 10) {
            System.out.println("Med");
        } else if (count >= 20) {
            System.out.println("High");
        } else {
            System.out.println("");
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
