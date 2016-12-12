package cn.qiang.zhang.logger;

import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;

/**
 * 这里适配的是{@link Logger}工具。
 * <p>
 * Created by mrZQ on 2016/12/12.
 */
public final class LoggerPrint {

    public Settings init() {
        return Logger.init();
    }

    public Settings init(String tag) {
        return Logger.init(tag);
    }

    public final IPrint loggerPrint = new IPrint() {
        @Override
        public int v(String tag, String msg) {
            Logger.t(tag).v(msg);
            return 0;
        }

        @Override
        public int v(String tag, String msg, Throwable tr) {
            Logger.log(Logger.VERBOSE, tag, msg, tr);
            return 0;
        }

        @Override
        public int d(String tag, String msg) {
            Logger.t(tag).d(msg);
            return 0;
        }

        @Override
        public int d(String tag, String msg, Throwable tr) {
            Logger.log(Logger.DEBUG, tag, msg, tr);
            return 0;
        }

        @Override
        public int i(String tag, String msg) {
            Logger.t(tag).i(msg);
            return 0;
        }

        @Override
        public int i(String tag, String msg, Throwable tr) {
            Logger.log(Logger.INFO, tag, msg, tr);
            return 0;
        }

        @Override
        public int w(String tag, String msg) {
            Logger.t(tag).w(msg);
            return 0;
        }

        @Override
        public int w(String tag, String msg, Throwable tr) {
            Logger.log(Logger.WARN, tag, msg, tr);
            return 0;
        }

        @Override
        public int w(String tag, Throwable tr) {
            Logger.log(Logger.INFO, tag, null, tr);
            return 0;
        }

        @Override
        public int e(String tag, String msg) {
            Logger.t(tag).e(msg);
            return 0;
        }

        @Override
        public int e(String tag, String msg, Throwable tr) {
            Logger.log(Logger.ERROR, tag, msg, tr);
            return 0;
        }

        @Override
        public int wtf(String tag, Throwable tr) {
            Logger.log(Logger.ASSERT, tag, null, tr);
            return 0;
        }

        @Override
        public int wtf(String tag, String msg) {
            Logger.t(tag).wtf(msg);
            return 0;
        }

        @Override
        public int wtf(String tag, String msg, Throwable tr) {
            Logger.log(Logger.ASSERT, tag, msg, tr);
            return 0;
        }
    };
}
