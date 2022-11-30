package gof23.statemachine;

public class Test {

    public static void main(String[] args) {

        MarioStateMachine machine = new MarioStateMachine();
        machine.obtainCape();
        State currentState = machine.getCurrentState();
        int score = machine.getScore();
    }
}
