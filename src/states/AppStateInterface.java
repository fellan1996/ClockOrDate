package states;

public interface AppStateInterface {
    void display();
    AppStateEnum getNextState(String userInput);
}
