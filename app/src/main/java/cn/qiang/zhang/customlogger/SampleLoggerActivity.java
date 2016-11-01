package cn.qiang.zhang.customlogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.qiang.zhang.logger.Log;
import cn.qiang.zhang.logger.logger.Logger;

/**
 * <h3>
 * 兼容方案，第三方日志工具与系统工具轻松转换，样例
 * </h3><br>
 * 这里将展示兼容工具的使用方法，显而易见的是，无论是怎样的工具，都为了方便使用而创造。<br>
 * 通常的步骤是，初始化/参数设定、直接使用。<br>
 * 多线程环境下可能无法保持既有的显示顺序，且不论如何在最后总是调用系统日志工具{@link android.util.Log}。
 * 因此，所谓的第三方日志工具与当前兼容工具，仅为了美观或条目清晰而存在。
 * <p>
 * Created by mrZQ on 2016/11/01.
 */
public class SampleLoggerActivity extends AppCompatActivity {

    private static final String TAG = "SampleLoggerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_logger);
        // 说明Log的使用方法，关于第三方日志工具，可以在这里找到：https://github.com/orhanobut/logger
        explainLog();
    }

    /**
     * 在这里，将讲述如何使用Log日志兼容工具
     */
    private void explainLog() {
        /*开始*/
        // 1.1 使用Logger需要这样做
        Logger.init();
        // 1.2 自定义或重设Logger的TAG
        Logger.init("CustomTAG");
        // 1.2 第三方工具的其他方法，直接调用，但肯定要对使用这种方法进行考量
        Logger.json("{json:这是json格式吗？}");
        // 2.1 使用兼容的Log日志工具，需要这样做
        Log.initCustomLogger();
        // 2.2 设置兼容的Log日志工具TAG，需要这样做
        Log.setIsCustomTag(true);
        Log.d(TAG, "打印TAG头");
        // 3.1 兼容其他第三方日志工具或自定义兼容接口，可以这样做
        Log.setCustomLogger(new MyLogger());
        Log.d(TAG, "自定义兼容接口");
        // 3.2 使用Log打印简单消息
        Log.d("这是一个简单的小日志");
        /*结束*/
    }

    public class MyLogger implements Log.ICustomLogger {

        @Override
        public int v(String tag, String msg) {
            return 0;
        }

        @Override
        public int v(String tag, String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int d(String tag, String msg) {
            Logger.d("%s" + msg, tag);
            return 0;
        }

        @Override
        public int d(String tag, String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int i(String tag, String msg) {
            return 0;
        }

        @Override
        public int i(String tag, String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int w(String tag, String msg) {
            return 0;
        }

        @Override
        public int w(String tag, String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int w(String tag, Throwable tr) {
            return 0;
        }

        @Override
        public int e(String tag, String msg) {
            return 0;
        }

        @Override
        public int e(String tag, String msg, Throwable tr) {
            return 0;
        }

        @Override
        public int wtf(String tag, Throwable tr) {
            return 0;
        }

        @Override
        public int wtf(String tag, String msg) {
            return 0;
        }

        @Override
        public int wtf(String tag, String msg, Throwable tr) {
            return 0;
        }
    }

}
