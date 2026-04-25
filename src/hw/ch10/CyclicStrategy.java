package hw.ch10;

class CyclicStrategy implements Strategy {
    int currentHandValue = 0;

    @Override
    public Hand nextHand() {
        Hand hand = Hand.getHand(currentHandValue);
        currentHandValue = (currentHandValue + 1) % 3;
        return hand;
    }

    @Override
    public void study(boolean win) {
        // 학습 필요 X    
    }
}