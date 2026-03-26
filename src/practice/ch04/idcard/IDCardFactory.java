package practice.ch04.idcard;

import practice.ch04.framework.Factory;
import practice.ch04.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100; // 카드 번호

    @Override
    protected Product createProduct(String owner) { // 부모타입 리턴
        return new IDCard(owner, serial++); 
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
