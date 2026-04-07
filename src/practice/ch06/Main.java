package practice.ch06;

import practice.ch06.framework.Manager;

public class Main {
    public static void main(String[] args) {
        // // 원본을 이용
        // MessageBox m1 = new MessageBox('@');
        // m1.use("Hello, world.");

        // // 복제본을 이용
        // m1.createCopy().use("Hello, world.");

        // // 원본을 이용
        // UnderlinePen u1 = new UnderlinePen('-');
        // u1.use("Hello, world.");

        // // 복제본을 이용
        // u1.createCopy().use("Hello, world.");
    
        Manager manager = new Manager();
        
        MessageBox mbox1 = new MessageBox('*');
        manager.register("star box", mbox1);

        UnderlinePen upen1 = new UnderlinePen('-');
        manager.register("underline pen", upen1);

        
        MessageBox mbox2 = new MessageBox('/');
        manager.register("slash box", mbox2);

        // 복제 객체를 이용
        manager.create("star box").use("Hello, world.");
    }
}
