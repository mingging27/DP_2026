package ch05.A2b;

public enum Triple {
    ALPHA, BETA, GAMMA; // 각 상수에 Triple 객체가 하나씩 만들어져서 저장됨

    private Triple() {
        System.out.println("The instance " + this + " is created.");
    }

    public static Triple getInstance(String name) {
        return valueOf(name);
    }
}
