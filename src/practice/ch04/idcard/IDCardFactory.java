package practice.ch04.idcard;

import practice.ch04.framework.Factory;
import practice.ch04.framework.Product;
import java.util.HashMap;
import java.util.Map;

public class IDCardFactory extends Factory {
    private int serial = 100; // 카드 번호
    private Map<Integer, String> owners = new HashMap<>();

    @Override
    protected Product createProduct(String owner) { // 부모타입 리턴
        return new IDCard(owner, serial++); 
    }

    @Override
    protected void registerProduct(Product product) {
        owners.put(((IDCard)product).getSerial(), ((IDCard)product).getOwner());
        System.out.println(product + "을 등록했습니다.");
    }

    public Map<Integer, String> getOwners() {
        return owners;
    }
}
