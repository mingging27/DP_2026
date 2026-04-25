package practice.ch10;

public class Main {
    public static void main(String[] args) {
        // Hand h1 = Hand.ROCK;
        // Hand h2 = Hand.SCISSORS;

        // if (h1.isStrongerThan(h2)) {
        //     System.out.println(h1 + "이 " + h2 + "보다 강하다.");
        // } else if (h1.isWeakerThan(h2)) {
        //     System.out.println(h1 + "이 " + h2 + "보다 약하다.");
        // } else {
        //     System.out.println(h1 + "과 " + h2 + "는 비겼다.");
        // }

        // 플레이어 2명 생성
        Player player1 = new Player("박민주", new RandomStrategy(314)); // 부모 타입으로 생성함 -> 자식 객체 참조 가능 (다형성)
        Player player2 = new Player("홍길동", new WinningStrategy(159));    // 하드 코드 되었음 (코드 상에 직접 입력되어있음) -> 변경을 위해서는 컴파일 새로 해야함

        // 게임 시키기
        for (int i = 0; i < 1000; i++) {
            Hand h1 = player1.nextHand();
            Hand h2 = player2.nextHand();

            if (h1.isStrongerThan(h2)) {
                player1.win();
                player2.lose();
            } else if (h1.isWeakerThan(h2)) {
                player1.lose();
                player2.win();
            } else {
                player1.even();
                player2.even(); 
            }
        }

        System.out.println("Total result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}
