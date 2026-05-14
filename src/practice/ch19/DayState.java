package practice.ch19;

// 싱글톤 패턴
public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() {    // 생성자 private
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(주간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {
        return "[주간]";
    }
}
