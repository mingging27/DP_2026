package hw.ch02;

public class Main {
    public static void main(String[] args) {
        System.out.println("20230949 박민주");

        Charger koreanCharger = new KoreanOutletAdaptor();
        Smartphone smartphone = new Smartphone(koreanCharger);
        smartphone.charge();
    }
}
