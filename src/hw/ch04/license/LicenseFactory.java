package hw.ch04.license;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class LicenseFactory extends Factory {
    private int licenseCounter = 100;
    private String baseDate;

    public LicenseFactory(String baseDate) {
        this.baseDate = baseDate;
    }

    @Override
    protected Product createProduct(String holder) {
        return new LicenseCard(holder, licenseCounter++, baseDate, "2031-3-19");
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
