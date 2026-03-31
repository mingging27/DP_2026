package practice.ch04;

import java.util.Map;
import practice.ch04.framework.Product;
import practice.ch04.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        // IDCard c = new IDCard("박민주");
        // c.use();
        
        // 공장을 통해 카드 생성
        IDCardFactory f = new IDCardFactory();
        Product p1 = f.create("박민주"); // 리턴이 Product 타입이므로 받는 변수도 Product 타입이어야 함
        p1.use();
        System.out.println("-------");

        Product p2 = f.create("김철수");
        p2.use();
        System.out.println("-------");

        
        Product p3 = f.create("이영희");
        p3.use();
        System.out.println("-------");
        
        // 해시맵 테스트: 시리얼번호와 오너 이름 대응표 출력
        Map<Integer, String> owners = f.getOwners();
        System.out.println("시리얼번호와 오너 대응표:");
        owners.forEach((key, value) -> System.out.println("시리얼: " + key + ", 오너: " + value));
    }
}
