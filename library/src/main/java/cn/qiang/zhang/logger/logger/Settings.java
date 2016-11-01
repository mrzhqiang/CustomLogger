package cn.qiang.zhang.logger.logger;

/**
 * <h3>
 * 日志设置类
 * </h3><br>
 * 日志打印信息在这里设置，比如方法数量、是否显示线程信息等。
 * <p>
 * Created by mrZQ on 2016/10/12.
 */
public final class Settings {
    private int methodCount = 2;
    private boolean showThreadInfo = true;
    private int methodOffset = 0;
    private LogAdapter logAdapter;

    /**
     * Determines to how logs will be printed
     */
    private LogLevel logLevel = LogLevel.FULL;

    public Settings hideThreadInfo() {
        showThreadInfo = false;
        return this;
    }

    public Settings methodCount(int methodCount) {
        if (methodCount < 0) {
            methodCount = 0;
        }
        this.methodCount = methodCount;
        return this;
    }

    public Settings logLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public Settings methodOffset(int offset) {
        this.methodOffset = offset;
        return this;
    }

    public Settings logAdapter(LogAdapter logAdapter) {
        this.logAdapter = logAdapter;
        return this;
    }

    int getMethodCount() {
        return methodCount;
    }

    boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    LogLevel getLogLevel() {
        return logLevel;
    }

    int getMethodOffset() {
        return methodOffset;
    }

    LogAdapter getLogAdapter() {
        if (logAdapter == null) {
            logAdapter = new AndroidLogAdapter();
        }
        return logAdapter;
    }

    void reset() {
        methodCount = 2;
        methodOffset = 0;
        showThreadInfo = true;
        logLevel = LogLevel.FULL;
    }
}
