package hw.ch10;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== RandomStrategy =====");
        Player player1 = new Player("Taro", new RandomStrategy(0));

        System.out.println("\n===== CyclicStrategy =====");
        Player player2 = new Player("Bob", new CyclicStrategy());
        // CyclicStrategy 테스트: 순환 확인
        System.out.println("CyclicStrategy 의 손가락 순환:");
        Strategy cyclic = new CyclicStrategy();
        for (int i = 0; i < 9; i++) {
        Hand hand = cyclic.nextHand();
        System.out.println((i+1) + "번째: " + hand);
        cyclic.study(false); // study 호출해도 영향 없음
        }

        // if (args.length != 2) {
        //     System.out.println("Usage: java Main randomseed1 randomseed2");
        //     System.out.println("Example: java Main 314 15");
        //     System.exit(0);
        // }
        // int seed1 = Integer.parseInt(args[0]);
        // int seed2 = Integer.parseInt(args[1]);
        // Player player1 = new Player("Taro", new ProbStrategy(seed1));
        // Player player2 = new Player("Hana", new RandomStrategy(seed2));
        // for (int i = 0; i < 10000; i++) {
        //     Hand nextHand1 = player1.nextHand();
        //     Hand nextHand2 = player2.nextHand();
        //     if (nextHand1.isStrongerThan(nextHand2)) {
        //         System.out.println("Winner:" + player1);
        //         player1.win();
        //         player2.lose();
        //     } else if (nextHand2.isStrongerThan(nextHand1)) {
        //         System.out.println("Winner:" + player2);
        //         player1.lose();
        //         player2.win();
        //     } else {
        //         System.out.println("Even...");
        //         player1.even();
        //         player2.even();
        //     }
        // }
        // System.out.println("Total result:");
        // System.out.println(player1.toString());
        // System.out.println(player2.toString());
    }
}
