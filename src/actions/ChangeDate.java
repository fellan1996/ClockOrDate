package actions;

import states.AppStateEnum;
import states.AppStateInterface;

public class ChangeDate implements AppStateInterface {
    static String currentDate = "2023:10:06";
    @Override
    public void display() {
        System.out.println("Enter a new date in the format 'YYYY:MM:DD");
    }

    @Override
    public AppStateEnum getNextState(String userInput) {
        currentDate = userInput;
        return AppStateEnum.DISPLAY_DATE;
    }
}
