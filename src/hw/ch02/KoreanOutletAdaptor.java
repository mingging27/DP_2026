package hw.ch02;

public class KoreanOutletAdaptor implements Charger {
    private KoreanOutlet koreanOutlet;

    public KoreanOutletAdaptor() {
        this.koreanOutlet = new KoreanOutlet();
    }

    @Override
    public int charge() {
        return koreanOutlet.provide();  // 위임
    }
    
}
