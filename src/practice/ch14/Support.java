package practice.ch14;


public abstract class Support {
    private String name;    // 이 트러블 해결자 이름
    private Support next;   // 떠넘길 곳

    public Support(String name) {
        this.name = name;
        this.next = null;
    }

    // 떠넘길 곳을 설정한다
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    // 트러블 해결 절차를 결정한다
    // 템플릿 메소드
    public void support(Trouble trouble) {
        if (resolve(trouble)) { // 자기가 해결하려고 함
            done(trouble);  // 해결햇다고 선언
        } else if (next != null) {  // 자기가 해결 못 햇는데, 뒷 사람이 잇으면
            next.support(trouble);  // 뒷사람에게 떠넘김 (재귀적 호출)
        } else {    // 자기도 해결 못 햇고, 뒷 사람도 없으면
            fail(trouble); // 해결 못 햇다고 선언
        }
    }

    // 트러블 해결자의 문자열 표현
    @Override
    public String toString() {
        return "[" + name + "]";
    }

    // 해결하려고 한다
    protected abstract boolean resolve(Trouble trouble);

    // 해결했다 
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    // 해결되지 않았다 
    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
