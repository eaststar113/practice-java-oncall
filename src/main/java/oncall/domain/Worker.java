package oncall.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Worker {
    public static ArrayList<String> weekdaysWorkerInput;

    public Worker(String weekdaysWorker){
        this.weekdaysWorkerInput = new ArrayList<>();
        validateWeekdays(weekdaysWorker);
    }
    public static void validateWeekdays(String inputWorkDate) {
        String[] splitWithComma = inputWorkDate.split(",",-1);
        List<String> confirmWeekdaysWorker = removeBlank(splitWithComma);
        Set<String> confirmDuplicate = new HashSet<>();
        checkLengthSize(confirmWeekdaysWorker);
        for(String weekdaysWorker:confirmWeekdaysWorker){
            checkWorkerNameLength(weekdaysWorker);
            duplicateWeekdaysWorker(weekdaysWorker, confirmDuplicate);
        }
        weekdaysWorkerInput.addAll(confirmWeekdaysWorker);
    }
    private static void duplicateWeekdaysWorker(String name, Set<String> confirmDuplicate){
        if(!confirmDuplicate.add(name)){
            throw new IllegalArgumentException("duplicate name");
        }
    }
    private static void checkLengthSize(List<String> confirmWeekdaysWorker){
        if(confirmWeekdaysWorker.size() < 5 || confirmWeekdaysWorker.size() > 35){
            throw new IllegalArgumentException("weekdaysworker size error");
        }
    }
    private static void checkWorkerNameLength(String element){
        if(element.length() > 5){
            throw new IllegalArgumentException("weekdaysworker name size error");
        }
    }
    static List<String> removeBlank(String[] elements) {
        List<String> names = new ArrayList<>();
        for (String element : elements) {
            String trimmedElement = element.trim();
            names.add(trimmedElement);
        }
        return names;
    }
}
