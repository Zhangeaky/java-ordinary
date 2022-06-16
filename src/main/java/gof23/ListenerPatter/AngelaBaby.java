package gof23.ListenerPatter;

import java.util.HashMap;
import java.util.Map;

public class AngelaBaby implements Baby{

    Map<String, Listener> listeners = new HashMap<>();

    @Override
    public void registerListener(String name, Listener listener) {


    }

    @Override
    public void removeListener(Listener listener) {


    }

    @Override
    public void findListener(Listener listener) {



    }

    @Override
    public void notifyListener() {

    }
}
