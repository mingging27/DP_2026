package practice.ch04.idcard;

import practice.ch04.framework.Product;   // 다른 패키지에 있으므로 import 필요

public class IDCard extends Product {
    private String owner;
    private int serial;

    IDCard(String owner, int serial) {
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");    // 문자열 합성 -> toString() 메소드가 자동으로 호출됨
    }

    @Override
    // 이 객체의 문자열이 필요할 때 자동으로 호출되는 메소드 
    // Object 클래스(최상위 클래스)의 toString() 메소드 오버라이드
    public String toString() {
        return "[IDCard: " + owner + ", Serial: " + serial + "]";
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
