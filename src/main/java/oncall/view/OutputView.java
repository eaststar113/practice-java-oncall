package oncall.view;

import static oncall.domain.Holiday.isHoliday;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import oncall.domain.WorkDate;

public class OutputView {
    //입력받은 요일 기준으로 일주일 순회
    //근무자
    //휴일 지정
    public static void displayOnCall(String month,String week) {
        int onCallMonth = WorkDate.transMonthtoInt(month);
        int days = findMonthPerDays(onCallMonth);
        Deque<String> weeks = findTheDayOfWeek(week);
        for(int i = 1;i <= days;i++){
            String getTodayWeek = weeks.poll();
            System.out.print(onCallMonth + "월 " + i + "일 " + getTodayWeek);
            if(isHoliday(onCallMonth,i)){

            }
            System.out.println();
            weeks.add(getTodayWeek);
        }
    }
    public static Deque<String> findTheDayOfWeek(String week) {
        List<String> weekListUp = List.of("월","화","수","목","금","토","일");
        Deque<String> originalWeek = new ArrayDeque<>(weekListUp);
        for(String w : originalWeek){
            String m = originalWeek.poll();
            if(Objects.equals(m, week)){
                originalWeek.addFirst(m);
                break;
            }
            originalWeek.add(m);
        }
        return originalWeek;
    }
    public static Integer findMonthPerDays(Integer month) {
        List<Integer> daysWithThirtyOne = List.of(1,3,5,7,8,10,12);
        List<Integer> daysWithThirty = List.of(4,6,9,11);
        if(daysWithThirty.contains(month)){
            return 30;
        }
        if(daysWithThirtyOne.contains(month)){
            return 31;
        }
        return 28;
    }
}
