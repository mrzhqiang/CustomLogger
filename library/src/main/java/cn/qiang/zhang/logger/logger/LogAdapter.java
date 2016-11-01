package cn.qiang.zhang.logger.logger;

/**
 * <h3>
 * 日志适配器接口
 * </h3><br>
 * 通过调用这个接口来实现日志打印，将具体细节交由用户控制，或自定义或预定义。
 * <p>
 * Created by mrZQ on 2016/10/12.
 */
public interface LogAdapter {
    void d(String tag, String message);

    void e(String tag, String message);

    void w(String tag, String message);

    void i(String tag, String message);

    void v(String tag, String message);

    void wtf(String tag, String message);
}
