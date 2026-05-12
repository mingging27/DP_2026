package hw.ch16;

import java.awt.Color;
import java.awt.Label;

public class ColleagueLable extends Label implements Colleague {
    Mediator mediator;

    public ColleagueLable(String caption) {
        super(caption);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        
        if (enabled) {
            setForeground(Color.blue);
            setText("● 로그인 가능");
        } else {
            setForeground(Color.red);
            setText("● 로그인 불가");
        }        
    }
}
