package practice.ch16;

import java.awt.Button;

// Colleage 구현, Button 상속
public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    // 생성자
    public ColleagueButton(String caption) {
        super(caption); // 버튼에 나타나는 글자 설정
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);    // 부모인 Button로부터 상속받은 setEnabled()를 호출한다
    }
}
