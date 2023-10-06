package actions;

import states.*;
public class DisplayTime implements AppStateInterface {

    @Override
    public void display() {
        System.out.println("The current time is: " + ChangeTime.currentTime);
        System.out.println("Enter 'c' to change time or enter 'd' to display the date instead");
    }

    @Override
    public AppStateEnum getNextState(String userInput) {
        if(userInput.equals("c")){
            return AppStateEnum.CHANGE_TIME;
        } else if (userInput.equals("d")) {
            return AppStateEnum.DISPLAY_DATE;
        }
        return null;
    }

}
