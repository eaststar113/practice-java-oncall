package oncall.domain;

public enum Holiday {
    FIRST(1, 1, "신정"),
    SECOND(3, 1, "삼일절"),
    THIRD(5, 5, "어린이날"),
    FOURTH(6, 6, "현충일"),
    FIFTH(8, 15, "광복절"),
    SIXTH(10, 3, "개천절"),
    SEVENTH(10, 9, "한글날"),
    EIGHTH(12, 25, "성탄절");

    private final Integer holidayMonth;
    private final Integer holidayDay;
    private final String holidayName;

    Holiday(Integer holidayMonth, Integer holidayDay, String holidayName) {
        this.holidayMonth = holidayMonth;
        this.holidayDay = holidayDay;
        this.holidayName = holidayName;
    }

    public static boolean isHoliday(int month, int day){
        for(Holiday holiday: Holiday.values()){
            if(month == holiday.getHolidayMonth() && day == holiday.getHolidayDay()){
                return true;
            }
        }
        return false;
    }

    public Integer getHolidayMonth() {
        return holidayMonth;
    }

    public Integer getHolidayDay() {
        return holidayDay;
    }

    public String getHolidayName() {
        return holidayName;
    }
}
