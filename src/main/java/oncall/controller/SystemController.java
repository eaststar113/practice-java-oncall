package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.WorkDate;
import oncall.domain.Worker;
import oncall.view.InputView;

public class SystemController {
    public void run(){
        WorkDate workDate = inputPurchasePrice();
        List<Worker> worker = inputWorker();
    }

    private WorkDate inputPurchasePrice() {
        while (true) {
            try {
                String workDate = InputView.readWorkDate();
                return new WorkDate(workDate);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Worker> inputWorker() {
        List<Worker> workers = new ArrayList<>();
        while (true) {
            try {
                Worker weekdaysWorker = new Worker(InputView.readWeekdaysWorker());
                Worker holidaysWorker = new Worker(InputView.readHolidaysWorker());
                workers.add(weekdaysWorker);
                workers.add(holidaysWorker);
                return workers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
