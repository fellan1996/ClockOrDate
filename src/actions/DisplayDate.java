package actions;

import states.AppStateEnum;
import states.AppStateInterface;

public class DisplayDate implements AppStateInterface {
    @Override
    public void display() {
        System.out.println("The current date is: " + ChangeDate.currentDate);
        System.out.println("Enter 'c' to change date or enter 'd' to display the time instead");
    }

    @Override
    public AppStateEnum getNextState(String userInput) {
        if(userInput.equals("c")){
            return AppStateEnum.CHANGE_DATE;
        } else if (userInput.equals("d")) {
            return AppStateEnum.DISPLAY_TIME;
        }
        return null;
    }
}
