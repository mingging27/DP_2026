package practice.ch04;

import practice.ch04.framework.Product;
import practice.ch04.idcard.IDCardFactory;;

public class Main {
    public static void main(String[] args) {
        // IDCard c = new IDCard("박민주");
        // c.use();
        
        // 공장을 통해 카드 생성
        IDCardFactory f = new IDCardFactory();
        Product p = f.create("박민주"); // 리턴이 Product 타입이므로 받는 변수도 Product 타입이어야 함
        p.use();
    }
}
