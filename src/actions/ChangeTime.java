package actions;

import states.AppStateEnum;
import states.AppStateInterface;

//TODO Ändra överallt från public till en mer säker access modifier
public class ChangeTime implements AppStateInterface {
    static String currentTime = "00:00:00";

    @Override
    public void display() {
        System.out.println("Enter a new time in the format 'HH:MM:SS'");
    }

    @Override
    public AppStateEnum getNextState(String userInput) {

        if (userInput.equals("changeDate")) {
            System.out.println("Not able to change date while in changeTime");
            return AppStateEnum.DISPLAY_TIME;
        } else if (userInput.equals("displayDate")) {
            System.out.println("Not able to display date while in changeDate");
            return AppStateEnum.DISPLAY_TIME;
        } else if (userInput.equals("displayTime")) {
            return AppStateEnum.DISPLAY_TIME;
        } else if (userInput.equals("changeTime")) {
            return AppStateEnum.CHANGE_TIME;
        } else {
            String timePattern = "^([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
            if (userInput.matches(timePattern)) {
                currentTime = userInput;
            } else {
                System.out.println("Invalid time format. Use 'HH:MM:SS' format next time.");
            }
            return AppStateEnum.DISPLAY_TIME;
        }
    }

}
