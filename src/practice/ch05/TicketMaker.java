package practice.ch05;

public class TicketMaker {
        private int ticket = 1000; // 티켓 번호
        public static TicketMaker t = new TicketMaker(); // 싱글톤 객체
    
        private TicketMaker() {
            System.out.println("Ticket이 생성됩니다.");
        }

        public static TicketMaker getInstance() {
            return t;
        }

        public int getNextTicketNumber() {
            return ticket++;
        }
}
