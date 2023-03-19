package com.zhangeaky.se.util.event;

import java.util.ArrayList;

public class MyEventPublisher {

    private final ArrayList<MyEventListener> listeners = new ArrayList<MyEventListener>();

    public void publishEvent() {

    }

    public void addListeners(MyEventListener listener) {
        listeners.add(listener);
    }

    public void removeListeners() {

    }

    public void removeAllListeners() {

    }

    public static void main(String[] args) {

    }
}
