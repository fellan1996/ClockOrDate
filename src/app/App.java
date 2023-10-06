// App.java
package app;

import actions.*;
import states.*;

import java.util.Scanner;

public class App {
    private AppStateEnum currentState;

    public App() {
        currentState = AppStateEnum.DISPLAY_TIME;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            switch (currentState) {
                case DISPLAY_TIME:
                    DisplayTime displayTime = new DisplayTime();
                    displayTime.display();
                    userInput = scanner.nextLine().trim();
                    System.out.println(userInput + " userInput");
                    currentState = displayTime.getNextState(userInput);
                    break;
                case CHANGE_TIME:
                    ChangeTime changeTime = new ChangeTime();
                    changeTime.display();
                    userInput = scanner.nextLine().trim();
                    currentState = changeTime.getNextState(userInput);
                    break;
                case DISPLAY_DATE:
                    DisplayDate displayDate = new DisplayDate();
                    displayDate.display();
                    userInput = scanner.nextLine().trim();
                    currentState = displayDate.getNextState(userInput);
                    break;
                case CHANGE_DATE:
                    ChangeDate changeDate = new ChangeDate();
                    changeDate.display();
                    userInput = scanner.nextLine().trim();
                    currentState = changeDate.getNextState(userInput);
                    break;
                default:
                    System.out.println("Invalid state");
                    break;
            }

            if (currentState == null) {
                System.out.println("Error - Invalid entry");
                break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
