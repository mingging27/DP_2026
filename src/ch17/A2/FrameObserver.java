package ch17.A2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameObserver extends Frame implements Observer, ActionListener {
    // GraphText는 통지된 수를 텍스트 필드로 표시하는 static 클래스 
    // FrameObserver 안에서만 사용 가능한 클래스
    static class GraphText extends TextField implements Observer {
        public GraphText(int columns) {
            super(columns);
        }

        @Override
        public void update(NumberGenerator generator) {
            int number = generator.getNumber(); // 관찰 대상이 생성한 숫자 얻음
            String text = number + ":";
            for (int i = 0; i < number; i++) {
                text += '*';
            }
            setText(text);
        }
    }

    // GraphCanvas는 통지된 수를 원그래프로 표시하는 static 클래스 
    static class GraphCanvas extends Canvas implements Observer {
        private int number;

        @Override
        public void update(NumberGenerator generator) {
            number = generator.getNumber();
            repaint();  // 도화지를 클리어하고 paint()를 호출
        }

        // Graphics 객체를 이용하여 색깔 지정 및 그림 그림
        public void paint(Graphics g) { // 캔버스에 그림을 그림
            int width = getWidth();
            int height = getHeight();

            g.setColor(Color.white); // 흰 원을 그림
            g.fillArc(0, 0, width, height, 0, 360);
            
            g.setColor(Color.red); // 빨간 원호를 그림
            g.fillArc(0, 0, width, height, 90, - number * 360 / 50); // 인자 뒤의 2개가 중요, 앞 2개는 원을 그리는 영역
        }
    }

    private GraphText textGraph = new GraphText(60);
    private GraphCanvas canvasGraph = new GraphCanvas();
    private Button buttonClose = new Button("Close");

    public FrameObserver() {
        super("FrameObserver");
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        textGraph.setEditable(false);   // 위의 텍스트 필드 수정 안되게
        canvasGraph.setSize(500, 500);
        add(textGraph, BorderLayout.NORTH);
        add(canvasGraph, BorderLayout.CENTER);
        add(buttonClose, BorderLayout.SOUTH);
        
        // 버튼 눌럿을 때의 이벤트 처리
        buttonClose.addActionListener(this);

        // 프레임의 크기를 컴포넌트에 맞게 조정하고 표시한다
        pack();
        setVisible(true);
    }

    // 종료 버튼이 눌렸을 때의 이벤트 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void update(NumberGenerator generator) {
        textGraph.update(generator);
        canvasGraph.update(generator);
    }
}

