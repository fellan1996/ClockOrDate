package actions;

import states.AppStateEnum;
import states.AppStateInterface;

public class DisplayDate implements AppStateInterface {
    @Override
    public void display() {
        System.out.println("The current date is: " + ChangeDate.currentDate);
        System.out.println("Enter 'changeDate' to change date or enter 'displayTime' to display the time instead");
    }

    @Override
    public AppStateEnum getNextState(String userInput) {
        if(userInput.equals("changeDate")){
            return AppStateEnum.CHANGE_DATE;
        } else if (userInput.equals("displayTime")) {
            return AppStateEnum.DISPLAY_TIME;
        } else if (userInput.equals("changeTime")) {
            System.out.println("Not able to go to changeTime while in displayDate");
            return AppStateEnum.DISPLAY_DATE;
        } else if (userInput.equals("displayDate")) {
            return AppStateEnum.DISPLAY_DATE;
        }
        return null;
    }
}
