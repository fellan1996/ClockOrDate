// App.java
package app;

import actions.*;
import states.*;

import java.util.Scanner;

public class App {
    private AppStateEnum currentState;
    private final DisplayTime displayTime = new DisplayTime();
    private final ChangeTime changeTime = new ChangeTime();
    private final DisplayDate displayDate = new DisplayDate();
    private final ChangeDate changeDate = new ChangeDate();

    public App(AppStateEnum currentState) {
        this.currentState = currentState;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.println("");
            System.out.println("The state is currently: " + currentState);
            switch (currentState) {
                case DISPLAY_TIME -> {
                    displayTime.display();
                    userInput = scanner.nextLine().trim();
                    currentState = displayTime.getNextState(userInput);
                }
                case CHANGE_TIME -> {
                    changeTime.display();
                    userInput = scanner.nextLine().trim();
                    currentState = changeTime.getNextState(userInput);
                }
                case DISPLAY_DATE -> {
                    displayDate.display();
                    userInput = scanner.nextLine().trim();
                    currentState = displayDate.getNextState(userInput);
                }
                case CHANGE_DATE -> {
                    changeDate.display();
                    userInput = scanner.nextLine().trim();
                    currentState = changeDate.getNextState(userInput);
                }
                default -> System.out.println("Invalid state");
            }

            if (currentState == null) {
                System.out.println("Error - Invalid entry");
                break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        App app = new App(AppStateEnum.DISPLAY_TIME);
        app.run();
    }
}
