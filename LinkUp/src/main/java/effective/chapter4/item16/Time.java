package effective.chapter4.item16;

// 公共类暴露了不可变的字段 - 值得商榷（第79页）
// Public class with exposed immutable fields - questionable   (Page 79)
public final class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {
        if (hour < 0 || hour > HOURS_PER_DAY) {
            throw new IllegalArgumentException("Hour: " + hour);
        }
        if (minute < 0 || minute > MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("Minute: " + minute);
        }
        this.hour = hour;
        this.minute = minute;

        //剩余代码忽略
    }
}
