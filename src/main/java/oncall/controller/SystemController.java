package oncall.controller;

import oncall.domain.WorkDate;
import oncall.view.InputView;

public class SystemController {
    public void run(){
        WorkDate workDate = inputPurchasePrice();

    }

    private static WorkDate inputPurchasePrice() {
        while (true) {
            try {
                String workDate = InputView.readWorkDate();
                return new WorkDate(workDate);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
