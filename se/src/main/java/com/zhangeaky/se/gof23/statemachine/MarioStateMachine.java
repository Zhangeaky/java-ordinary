package com.zhangeaky.se.gof23.statemachine;

public class MarioStateMachine {

    private int score;

    private State currentState;

    public MarioStateMachine() {

        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushroom() {

    }

    public void obtainCape() {

    }

    public void meetMonster() {

    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }
}
