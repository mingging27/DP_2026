package ch22.Sample;

import ch22.Sample.command.*;
import ch22.Sample.drawer.*;
import java.awt.event.*;
import javax.swing.*;

// JFrame 상속, MouseMotionListener, WindowListener 구현
public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear");

    // 생성자 - UI 배치
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        // 람다식
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS); // 가로 배치
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS); // 세로 배치
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);  // 배치 완료

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());    // Drawable, position 전달
        history.append(cmd);
        cmd.execute();
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
