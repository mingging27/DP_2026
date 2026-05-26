package practice.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();   // 원소로 Command를 가지는 Deque(덱)

    // 실행 
    @Override
    public void execute() { // commands에 있는 모든 명령을 실행
        for (Command cmd: commands) {
            cmd.execute();  // 리커시브 호출
        }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {  // 자기 자신을 추가하면 무한 루프에 빠짐 -> 오류처리
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop(); // 나중에 들어온 명령을 꺼내라
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();   // 원소 전부 삭제
    }
}
