package hw.ch04;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;
import hw.ch04.idcard.IDCardFactory;
import hw.ch04.license.LicenseFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("20230949 박민주");

        // Step 1
        Factory factory1 = new IDCardFactory("2026-01-15");
        Product card1 = factory1.create("Kim Youngjin");
        Product card2 = factory1.create("Son Heungmin");
        card1.use();
        card2.use();

        // Product card3 = new LicenseCard("Minjae Lee", 201, "2026-03-21", "2031-03-20");
        // card3.use();

        // Step 2
        Factory factory2 = new LicenseFactory("2026-03-20");
        Product license1 = factory2.create("Park Jisung");
        Product license2 = factory2.create("Lee Min-jae");
        license1.use();
        license2.use();
    }
}
