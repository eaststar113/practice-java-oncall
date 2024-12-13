package oncall.domain;

public enum DayOfTheWeek {
    MONDAY(1, "월"),
    TUESDAY(2, "화"),
    WEDNESDAY(3, "수"),
    THURSDAY(4, "목"),
    FRIDAY(5, "금"),
    SATURDAY(6, "토"),
    SUNDAY(7, "일");

    private final Integer dayNumber;
    private final String dayName;

    DayOfTheWeek(Integer dayNumber, String dayName) {
        this.dayNumber = dayNumber;
        this.dayName = dayName;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public String getDayName() {
        return dayName;
    }
}
