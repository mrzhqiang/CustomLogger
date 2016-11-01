package cn.qiang.zhang.logger.logger;

import android.util.Log;

/**
 * <h3>
 * 预设Android日志适配器
 * </h3><br>
 * 事实上也是调用系统日志输出，可以通过实现LogAdapter接口自定义，具有灵活的扩展性。
 * <p>
 * Created by mrZQ on 2016/10/12.
 */
public class AndroidLogAdapter implements LogAdapter {
    @Override
    public void d(String tag, String message) {
        Log.d(tag, message);
    }

    @Override
    public void e(String tag, String message) {
        Log.e(tag, message);
    }

    @Override
    public void w(String tag, String message) {
        Log.w(tag, message);
    }

    @Override
    public void i(String tag, String message) {
        Log.i(tag, message);
    }

    @Override
    public void v(String tag, String message) {
        Log.v(tag, message);
    }

    @Override
    public void wtf(String tag, String message) {
        Log.wtf(tag, message);
    }
}
