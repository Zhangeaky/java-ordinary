package gof23.oop;

public class Api {

    private long maxTps;
    private long errorCount;

    public long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(long errorCount) {
        this.errorCount = errorCount;
    }

    public void setMaxTps(long maxTps) {
        this.maxTps = maxTps;
    }

    public long getMaxTps() {
        return maxTps;
    }
}
