package practice.ch04.framework;

public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);   // 실제 제품 생성
        registerProduct(p); // 생성된 제품을 등록
        return p;
    }

    // 구체적인 공장이 구현하는 메소드
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
