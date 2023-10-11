package actions;

import states.*;
public class DisplayTime implements AppStateInterface {

    @Override
    public void display() {
        System.out.println("The current time is: " + ChangeTime.currentTime);
        System.out.println("Enter 'changeTime' to change time or enter 'displayDate' to display the date instead");
    }

    @Override
    public AppStateEnum getNextState(String userInput) {
        if(userInput.equals("changeTime")){
            return AppStateEnum.CHANGE_TIME;
        } else if (userInput.equals("displayDate")) {
            return AppStateEnum.DISPLAY_DATE;
        } else if (userInput.equals("changeDate")) {
            System.out.println("Not able to go to changeDate while in displayTime");
            return AppStateEnum.DISPLAY_TIME;
        } else if (userInput.equals("displayTime")) {
            return AppStateEnum.DISPLAY_TIME;
        }
        return null;
    }

}
