package actions;

import states.AppStateEnum;
import states.AppStateInterface;

//TODO Ändra överallt från public till en mer säker access modifier
public class ChangeTime implements AppStateInterface {
    static String currentTime = "00:00";


    @Override
    public void display() {
        System.out.println("Set a new time in the format 'hh:mm'");
    }


    @Override
    public AppStateEnum getNextState(String userInput) {
        currentTime = userInput;
        return AppStateEnum.DISPLAY_TIME;
    }

}
