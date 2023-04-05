package com.zhangeaky.se.concurrent.juc.future;

public class Machine {

    public enum State {
        START,
        ONE,
        TWO,
        THREE,
        END;

        State step() {
            if (equals(END)) {
                return END;
            }

            return values() [ordinal() + 1];
        }
    }

    private State state = State.START;

    private final int id;

    public Machine(int id) {
        this.id = id;
    }

    public static Machine work(Machine m) {

        if (!m.state.equals(State.END)) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            m.state = m.state.step();

        }

        System.out.println(m);
        return m;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "state=" + state +
                ", id=" + id +
                '}';
    }
}
