package actions;

import states.AppStateEnum;
import states.AppStateInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeDate implements AppStateInterface {
    static String currentDate = "0000:00:00";
    @Override
    public void display() {
        System.out.println("Enter a new date in the format 'YYYY:MM:DD' ");
    }

    @Override
    public AppStateEnum getNextState(String userInput) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd");
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(userInput);
            currentDate = dateFormat.format(parsedDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format or invalid date. Please use 'YYYY:MM:DD' format with valid values.");
        }

        return AppStateEnum.DISPLAY_DATE;
    }
}
