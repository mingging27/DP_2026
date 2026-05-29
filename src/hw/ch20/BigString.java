package hw.ch20;

public class BigString {
    // 큰 문자의 배열 
    private BigChar[] bigchars;

    // 생성자(인수 없음, 공유한다)
    public BigString(String string) {
        initShared(string);
    }

    // 생성자(인수로 공유할지 말지 지정한다)
    public BigString(String string, boolean shared) {
        if (shared) {
            initShared(string);
        } else {
            initUnshared(string);
        }
    }

    // 공유해서 초기화 
    private void initShared(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];    // 큰 문자 인스턴스 저장 배열 생성
        // 공유여부에 따라 for문에서 차이 있음
        for (int i = 0; i < bigchars.length; i++) {
            // factory 사용
            bigchars[i] = factory.getBigChar(string.charAt(i)); // charAt(i)로 문자열에서 문자 하나씩 얻어서 factory에 전달하여 BigChar 인스턴스 얻음
        }
    }

    // 공유하지 않고 초기화 
    private void initUnshared(String string) {
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            // factory 사용하지 않고 BigChar 인스턴스 생성
            bigchars[i] = new BigChar(string.charAt(i));
        }
    }

    // 표시
    public void print() {   // bigchars 배열의 각 요소의 print() 호출
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }

    // color 추가
    public void print(String [] colors) {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print("\u001B" + colors[i]);
        }
    }
}
