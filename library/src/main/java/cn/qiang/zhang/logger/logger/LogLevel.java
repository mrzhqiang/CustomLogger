package cn.qiang.zhang.logger.logger;

/**
 * <h3>
 * 日志等级枚举
 * </h3><br>
 * 用于决定是否打印日志：{@link #FULL} 打印所有日志；{@link #NONE} 不打印所有日志。
 * <p>
 * Created by mrZQ on 2016/10/12.
 */

public enum LogLevel {

    /**
     * Prints all logs <br>
     * 完整
     */
    FULL,

    /**
     * No log will be printed <br>
     * 空无
     */
    NONE

}
