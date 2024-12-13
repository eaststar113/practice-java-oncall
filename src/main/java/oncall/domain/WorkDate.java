package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkDate {

    public static ArrayList<String> workDateAboutInput;

    public WorkDate(String workdate){
        this.workDateAboutInput = new ArrayList<>();
        validateWorkDate(workdate);
    }
    public static void validateWorkDate(String inputWorkDate) {
        String[] splitWithComma = inputWorkDate.split(",",-1);
        List<String> confirmCount = removeBlank(splitWithComma);
        checkLengthSize(confirmCount);
        checkFirstElementOfList(confirmCount.getFirst());
        checkLastElementOfList(confirmCount.getLast());
        workDateAboutInput.addAll(confirmCount);
    }
    private static void checkLengthSize(List<String> confirmCount){
        if(confirmCount.size()!=2){
            throw new IllegalArgumentException("size error");
        }
    }
    private static void checkFirstElementOfList(String element){
        if (element == null || element.isEmpty()) {
            throw new IllegalArgumentException("month empty");
        }
        try {
            int count = Integer.parseInt(element);
            if (count < 1 || count > 12) {
                throw new IllegalArgumentException("month out of range");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("month format error");
        }
    }
    private static void checkLastElementOfList(String element){
        for(DayOfTheWeek dayOfTheWeek: DayOfTheWeek.values()){
            if(Objects.equals(dayOfTheWeek.getDayName(), element)){
                return;
            }
        }
        throw new IllegalArgumentException("no day of the week");
    }
    static List<String> removeBlank(String[] elements) {
        List<String> names = new ArrayList<>();
        for (String element : elements) {
            String trimmedElement = element.trim();
            names.add(trimmedElement);
        }
        return names;
    }
    public static Integer transMonthtoInt(String month) {
        return Integer.parseInt(month);
    }
    public ArrayList<String> getWorkDateAboutInput() {
        return workDateAboutInput;
    }
    public static String getWorkDateAboutMonth() {
        return workDateAboutInput.getFirst();
    }
    public static String getWorkDateAboutWeek() {
        return workDateAboutInput.getLast();
    }
}
