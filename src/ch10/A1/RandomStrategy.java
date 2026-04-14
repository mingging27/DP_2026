package ch10.A1;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random;

    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public void study(boolean win) {    // 이전 손 상관 X
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }
}
