package hw.ch16;

import java.awt.Color;
import java.awt.Label;

public class ColleagueLable extends Label implements Colleague {

    public ColleagueLable(String caption) {
        super(caption);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        // Mediator는 Label이 사용할 일이 없으므로 아무것도 하지 않는다
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);

        if (enabled) {
            setForeground(Color.blue);
            setText("● 로그인 가능");
        } else {
            setForeground(Color.gray);
            setText("● 로그인 불가");
        }                
    }
}
