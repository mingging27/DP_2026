package practice.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // 생성자 - Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title);

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // (중요) 레이아웃 매니저를 사용해 4×2 그리드를 만든다
        setLayout(new GridLayout(4, 2));

        // Colleague를 생성한다 
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        // 활성/비활성 초기 설정을 한다
        colleagueChanged();

        // 표시한다 
        pack(); // 배치된 컴포넌트 크기에 맞게 프레임의 크기를 조절한다
        setVisible(true); // 프레임을 화면에 보이게 한다
    }

    // Colleague를 생성한다 => 생성햇다고 반드시 보이는 거 X, 배치해야됨
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup(); // 체크박스 그룹 생성
        checkGuest = new ColleagueCheckbox("Guest", g, true);   // 초기값 true
        checkLogin = new ColleagueCheckbox("Login", g, false); // 초기값 false

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*'); // 입력 시 -> *로 보여줌

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정 (등록)
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);   // 로그인 프레임이 Listener
        buttonCancel.addActionListener(this);
    }

    // (중요) Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            // 게스트 로그인 
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            // 사용자 로그인 
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // textUser 또는 textPass의 변경이 있다 
    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() > 3) {  // 사용자 이름이 입력됐다면
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 3) { // 비밀번호도 입력됐다면
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
