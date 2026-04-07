package hw.ch05;

public class LoggerSynchronizedLazy {
    private static LoggerSynchronizedLazy instance = null;

    private StringBuilder logBuffer;

    private LoggerSynchronizedLazy() {    // 생성자
        System.out.println("[LoggerSynchronizedLazy] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder();
        slowdown();   // 인스턴스 생성이 오래 걸리는 상황을 가정하여 slowdown() 메소드를 호출한다.
    }

    public static synchronized LoggerSynchronizedLazy getInstance() {
        if (instance == null) {
            instance = new LoggerSynchronizedLazy();
        }
        return instance;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000); // CPU를 내놓고 1초간 쉰다. 
        } catch (InterruptedException e) {
        }
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("]").append(message).append("\n");
        System.out.println("[LoggerSynchronizedLazy] " + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}
