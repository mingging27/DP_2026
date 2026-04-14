package practice.ch10;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;  // 직전에 낸 손의 값
private int currentHandValue = 0;   // 이번에 낼 손의 값 (가장 최근에 낸 손의 값)
    private int[][] history = {
        { 1, 1, 1, },
        { 1, 1, 1, },
        { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    // 핵심 전략 : 다음에 낼 손 결정
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue)); // 0 ~ (행의 합 - 1) 사이의 난수 생성
        int handvalue = 0;
        if (bet < history[currentHandValue][0]) {   // 첫번째 범위
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) { // 두번째 범위
            handvalue = 1;
        } else { // 세번째 범위
            handvalue = 2;  
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue); // 결정된 손 리턴
    }

    private int getSum(int handvalue) { // 행의 합 구함
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handvalue][i];   // 행 번호 고정, 열의 번호만 0, 1, 2로 변화
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHandValue][currentHandValue]++;
        } else {    // 패배 -> 나머지 손에 가중치 증가
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
