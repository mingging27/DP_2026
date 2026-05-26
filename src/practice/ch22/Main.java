package practice.ch22;

import practice.ch22.command.*;
import practice.ch22.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// JFrame: 윈도우 창을 만드는 클래스
// 이벤트 리스너 2개
// MouseMotionListener: 마우스 움직임 감지, WindowListener: 창 관련 이벤트 감지
public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear");

    // 생성자 
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);

        // 람다식 -> ActionListener 인터페이스의 actionPerformed 메소드 구현
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });

        // Panel 대신 Box 사용 
        Box buttonBox = new Box(BoxLayout.X_AXIS);  // 가로 배치
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);    // 세로 배치 -> 버튼과 캔버스가 수직으로 배치됨
        mainBox.add(buttonBox); 
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    // Command 패턴의 핵심: 마우스 드래그 이벤트가 발생했을 때 호출되는 메소드 (누름+이동)
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);    // 명령어 객체를 이력에 추가
        cmd.execute();  // 명령어 객체의 execute() 메소드 호출 -> 캔버스에 점이 그려짐
    }

    // WindowListener용 
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
