package ch20.A2;

public class Main {
    private static BigString[] bsarray = new BigString[10000];  // BigString 인스턴스 저장 배열 (많은 양의 문자열)

    public static void main(String[] args) {
        System.out.println("공유한 경우:");
        testAllocation(true);
        System.out.println("공유하지 않는 경우:");
        testAllocation(false);
    }

    public static void testAllocation(boolean shared) {
        for (int i = 0; i < bsarray.length; i++) {
            bsarray[i] = new BigString("1212123", shared);
        }
        showMemory();
    }

    // 메모리 사용량 표시
    public static void showMemory() {
        Runtime.getRuntime().gc();  // 가비지 컬렉션을 실행 -> 사용 가능한 메모리를 늘림
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // 총 메모리 - 사용 가능 메모리 = 사용 중인 메모리
        System.out.println("사용 메모리 = " + used);
    }
}
