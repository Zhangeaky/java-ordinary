package gof23.ListenerPatter;

public interface Baby {

    final public String EVENT_CRY = "CRY";
    final public String EVENT_HUNGRY = "HUNGRY";

    void registerListener(String name, Listener listener);
    void removeListener(Listener listener);
    void findListener(Listener listener);
    void notifyListener();
}
