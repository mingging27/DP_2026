package hw.ch05;

public enum LoggerEnum {
    INSTANCE;   // 상수에 객체 하나가 만들어서 저장됨 -> 따로 객체를 만들 필요 X

    private StringBuilder logBuffer;

    private LoggerEnum() {
        System.out.println("[LoggerEnum] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder();
    }

    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("]").append(message).append("\n");
        System.out.println("[LoggerEnum] " + message);
    }

    public String getLog() {
        return logBuffer.toString();
    }
}
