package practice.ch10;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) { // seed: 난수 생성기의 초기값
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) { // 이전에 졌다면
            prevHand = Hand.getHand(random.nextInt(3)); // 새로 만든다
        }
        return prevHand;    // 이전에 이겼다면 같은 것을 낸다
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
