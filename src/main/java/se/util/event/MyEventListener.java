package se.util.event;

public class MyEventListener implements BaseEventListener {


    @Override
    public void onMethodBegin(MyEvent event) {
        String methodName = event.getMethodName();
        System.out.println("Method " + methodName + "开始执行...");
    }

    @Override
    public void onMethodEnd(MyEvent event) {
        String methodName = event.getMethodName();
        System.out.println("Mtehod" + methodName + "执行结束...");
    }
}
