package practice.ch10;

public class Player {
    private String name;
    private Strategy strategy;  // player가 streategy 타입의 속성을 가짐 (부모 타입으로 선언 -> 모든 자식 전략 객체 참조 가능)
    private int wincount;
    private int losecount;
    private int gamecount;

    // 이름과 전략을 받아서 플레이어를 만든다 
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;   // 전략 객체에게 다음 손을 결정하도록 위임 (중요)
    }

    // 전략에 따라 다음 손을 결정한다
    public Hand nextHand() {
        return strategy.nextHand();
    }

    // 승리
    public void win() {
        strategy.study(true);
        wincount++;
        gamecount++;
    }

    // 패배
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    // 무승부 
    public void even() {
        gamecount++;
    }

    @Override
    public String toString() {
        return "["
            + name + ":"
            + gamecount + " games, "
            + wincount + " win, "
            + losecount + " lose"
            + "]";
    }
}
