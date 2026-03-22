package hw.ch02;

public class Main {
    public static void main(String[] args) {
        Charger koreanCharger = new KoreanOutletAdaptor();
        Smartphone smartphone = new Smartphone(koreanCharger);
        smartphone.charge();
    }
}
