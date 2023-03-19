package com.zhangeaky.se.gof23.oop;

public class Alert {

    private AlertRule rule;
    private Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.notification = notification;
        this.rule = rule;
    }

    public void check(String api, long requestCount, long errorCount, long duration) {

        long tps = requestCount / duration;
        if (tps > rule.getMachedApi(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.NORMAL, "msg");
        }

        if (errorCount > rule.getMachedApi(api).getErrorCount()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "");
        }

    }



}
