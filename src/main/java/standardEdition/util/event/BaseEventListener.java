package standardEdition.util.event;

import java.util.EventListener;

public interface BaseEventListener extends EventListener {
    void onMethodBegin(MyEvent event);
    void onMethodEnd(MyEvent event);
}
