package cn.qiang.zhang.logger;

import android.text.TextUtils;

import java.util.Locale;

import cn.qiang.zhang.logger.logger.Logger;

/**
 * <h3>
 * 自定义日志打印工具
 * </h3>
 * 通过完全兼容的接口，将系统日志打印工具替换为自定义日志工具，输出比较漂亮的内容格式<br>
 * 其中，json、xml、Map、List、Set等对象，推荐直接使用第三方打印工具{@link Logger}<br>
 * 基本内容最好使用自定义工具打印——1.完全兼容系统日志工具；2.减少信息冗余；3.替换只需要修改导入路径<br>
 * 注意：如果Application不进行初始化{@link #initCustomLogger()}，则表示使用系统自带日志工具
 * <p>
 * Created by mrZQ on 2016/10/13.
 */
public class Log {

    /** 自定义日志工具：头内容的格式化 */
    private static final String CONTENT_HEADER_FORMAT = " [%s.%s(L:%d)] ==>> ";
    /** 自定义日志工具：标签 */
    private static final String DEFAULT_TAG = "mrZQ";
    /** 自定义日志工具：打印接口 */
    private static ICustomLogger customLogger;
    /** 自定义日志工具：测试开关，Verbose */
    private static boolean showV = true;
    /** 自定义日志工具：测试开关，Debug */
    private static boolean showD = true;
    /** 自定义日志工具：测试开关，Info */
    private static boolean showI = true;
    /** 自定义日志工具：测试开关，Warn */
    private static boolean showW = true;
    /** 自定义日志工具：测试开关，Error */
    private static boolean showE = true;
    /** 自定义日志工具：测试开关，What the fuck */
    private static boolean showWtf = true;
    /** 自定义日志工具：是否使用自定义标签 */
    private static boolean isCustomTag = true;

    /** 不允许被实例化 */
    private Log() {/* cannot be instantiated */}

    /**
     * 设置你自己实现扩展的打印接口
     * @param customLogger 自定义扩展的日志打印接口，传null使用默认实现
     */
    public static void setCustomLogger(ICustomLogger customLogger) {
        Log.customLogger = customLogger;
        if (customLogger == null) {
            initCustomLogger();
        }
    }

    /** 初始化默认日志打印工具 */
    public static void initCustomLogger() {
        isCustomTag = false;
        Log.customLogger = new DefaultLogger();
    }

    /**
     * 简易调试打印
     * @param content 调试消息内容
     */
    public static void d(String content) {
        if (!showD) return;
        if (customLogger != null) {
            customLogger.d(getTag(), content);
        } else {
            android.util.Log.d(getTag(), content);
        }
    }

    /**
     * 系统相关的调试打印1
     * @param tag     标签
     * @param content 调试消息内容
     */
    public static void d(String tag, String content) {
        if (!showD) return;
        if (customLogger != null) {
            customLogger.d(getTag(tag), content);
        } else {
            android.util.Log.d(getTag(tag), content);
        }
    }

    /**
     * 系统相关的调试打印2
     * @param tag     标签
     * @param content 调试消息内容
     * @param tr      堆栈
     */
    public static void d(String tag, String content, Throwable tr) {
        if (!showD) return;
        if (customLogger != null) {
            customLogger.d(getTag(tag), content, tr);
        } else {
            android.util.Log.d(getTag(tag), content, tr);
        }
    }

    /**
     * 简易错误打印
     * @param content 错误消息内容
     */
    public static void e(String content) {
        if (!showE) return;
        if (customLogger != null) {
            customLogger.e(getTag(), content);
        } else {
            android.util.Log.e(getTag(), content);
        }
    }

    /**
     * 系统相关的错误打印1
     * @param tag     标签
     * @param content 错误消息内容
     */
    public static void e(String tag, String content) {
        if (!showE) return;
        if (customLogger != null) {
            customLogger.e(getTag(tag), content);
        } else {
            android.util.Log.e(getTag(tag), content);
        }
    }

    /**
     * 系统相关的错误打印2
     * @param tag     标签
     * @param content 错误消息内容
     * @param tr      堆栈
     */
    public static void e(String tag, String content, Throwable tr) {
        if (!showE) return;
        if (customLogger != null) {
            customLogger.e(getTag(tag), content, tr);
        } else {
            android.util.Log.e(getTag(tag), content, tr);
        }
    }

    /**
     * 简易信息打印
     * @param content 相关消息内容
     */
    public static void i(String content) {
        if (!showI) return;
        if (customLogger != null) {
            customLogger.i(getTag(), content);
        } else {
            android.util.Log.i(getTag(), content);
        }
    }

    /**
     * 系统相关的信息打印1
     * @param tag     标签
     * @param content 相关消息内容
     */
    public static void i(String tag, String content) {
        if (!showI) return;
        if (customLogger != null) {
            customLogger.i(getTag(tag), content);
        } else {
            android.util.Log.i(getTag(tag), content);
        }
    }

    /**
     * 系统相关的信息打印2
     * @param tag     标签
     * @param content 相关消息内容
     * @param tr      堆栈
     */
    public static void i(String tag, String content, Throwable tr) {
        if (!showI) return;
        if (customLogger != null) {
            customLogger.i(getTag(tag), content, tr);
        } else {
            android.util.Log.i(getTag(tag), content, tr);
        }
    }

    /**
     * 简易详情打印
     * @param content 详情消息内容
     */
    public static void v(String content) {
        if (!showV) return;
        if (customLogger != null) {
            customLogger.v(getTag(), content);
        } else {
            android.util.Log.v(getTag(), content);
        }
    }

    /**
     * 系统相关的详情打印1
     * @param tag     标签
     * @param content 详情消息内容
     */
    public static void v(String tag, String content) {
        if (!showV) return;
        if (customLogger != null) {
            customLogger.v(getTag(tag), content);
        } else {
            android.util.Log.v(getTag(tag), content);
        }
    }

    /**
     * 系统相关的详情打印2
     * @param tag     标签
     * @param content 详情消息内容
     * @param tr      堆栈
     */
    public static void v(String tag, String content, Throwable tr) {
        if (!showV) return;
        if (customLogger != null) {
            customLogger.v(getTag(tag), content, tr);
        } else {
            android.util.Log.v(getTag(tag), content, tr);
        }
    }

    /**
     * 简易警告打印
     * @param content 警告消息内容
     */
    public static void w(String content) {
        if (!showW) return;
        if (customLogger != null) {
            customLogger.w(getTag(), content);
        } else {
            android.util.Log.w(getTag(), content);
        }
    }

    /**
     * 系统相关的警告打印1
     * @param tag     标签
     * @param content 警告消息内容
     */
    public static void w(String tag, String content) {
        if (!showW) return;
        if (customLogger != null) {
            customLogger.w(getTag(tag), content);
        } else {
            android.util.Log.w(getTag(tag), content);
        }
    }

    /**
     * 系统相关的警告打印2
     * @param tag 标签
     * @param tr  堆栈
     */
    public static void w(String tag, Throwable tr) {
        if (!showW) return;
        if (customLogger != null) {
            customLogger.w(getTag(tag), tr);
        } else {
            android.util.Log.w(getTag(tag), tr);
        }
    }

    /**
     * 系统相关的警告打印3
     * @param tag     标签
     * @param content 警告消息内容
     * @param tr      堆栈
     */
    public static void w(String tag, String content, Throwable tr) {
        if (!showW) return;
        if (customLogger != null) {
            customLogger.w(getTag(tag), content, tr);
        } else {
            android.util.Log.w(getTag(tag), content, tr);
        }
    }

    /**
     * 简易诡异打印
     * @param content 诡异消息内容
     */
    public static void wtf(String content) {
        if (!showWtf) return;
        if (customLogger != null) {
            customLogger.wtf(getTag(), content);
        } else {
            android.util.Log.wtf(getTag(), content);
        }
    }

    /**
     * 系统相关的诡异打印1
     * @param tag     标签
     * @param content 诡异消息内容
     */
    public static void wtf(String tag, String content) {
        if (!showWtf) return;
        if (customLogger != null) {
            customLogger.wtf(getTag(tag), content);
        } else {
            android.util.Log.wtf(getTag(tag), content);
        }
    }

    /**
     * 系统相关的诡异打印2
     * @param tag 标签
     * @param tr  堆栈
     */
    public static void wtf(String tag, Throwable tr) {
        if (!showWtf) return;
        if (customLogger != null) {
            customLogger.wtf(getTag(tag), tr);
        } else {
            android.util.Log.wtf(getTag(tag), tr);
        }
    }

    /**
     * 系统相关的诡异打印3
     * @param tag     标签
     * @param content 诡异消息内容
     * @param tr      堆栈
     */
    public static void wtf(String tag, String content, Throwable tr) {
        if (!showWtf) return;
        if (customLogger != null) {
            customLogger.wtf(getTag(tag), content, tr);
        } else {
            android.util.Log.wtf(getTag(tag), content, tr);
        }
    }

    /**
     * 设置是否启用自定义标签
     * @param isCustomTag ture 表示使用自定义传入TAG；false 表示使用预定义默认TAG
     */
    public static void setIsCustomTag(boolean isCustomTag) {
        Log.isCustomTag = isCustomTag;
    }

    /**
     * 自定义日志工具：获取自定义的标签，如果标签为空，则自动赋为此类的名字
     * @return 默认标签，如果清空，则使用此类的名字
     */
    public static String getTag() {
        return TextUtils.isEmpty(DEFAULT_TAG)
                ? Log.class.getSimpleName()
                : DEFAULT_TAG;
    }

    /**
     * 自定义日志工具：根据是否打开自定义标签开关，进行TAG获取
     * @param tag 用户设置的标签
     * @return 需要显示的标签
     */
    public static String getTag(String tag) {
        return isCustomTag ? tag : getTag();
    }

    /**
     * 自定义日志工具：获取打印消息的最开始部分：即显示——类.方法(行数)
     * @param msg 需要打印的消息内容
     * @return 格式化后的消息内容，类似—— class.method(line) message
     */
    private static String getContentHeader(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return "Content is Empty!";
        }
        // 得到当前方法的堆栈信息对象数组
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        // 从数组中得到调用当前方法的（类.方法）下标
        int currentIndex = getCallerIndex(trace);
        // 如果下标越界，返回错误信息
        if (currentIndex < 0 || currentIndex >= trace.length) {
            return "Can not find classed and methods of information !\n" + msg;
        }
        try {
            msg = String.format(Locale.getDefault(),
                    CONTENT_HEADER_FORMAT,
                    getSimpleClassName(trace[currentIndex].getClassName()),
                    trace[currentIndex].getMethodName(),
                    trace[currentIndex].getLineNumber())
                    + msg;
        } catch (Exception e) {
            msg = "getContentHeader Exception!\n" + msg;
        }
        return msg;
    }

    /**
     * 获取方法调用者的位置信息
     * @param trace 日志打印时的堆栈信息
     * @return 调用者处于堆栈的下标位置
     */
    private static int getCallerIndex(StackTraceElement[] trace) {
        for (int i = 3; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(DefaultLogger.class.getName()) && !name.equals(Log.class.getName())) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 自定义日志工具：获取类名——简单方式
     * @param name 详细类名
     * @return 简单类名
     */
    private static String getSimpleClassName(String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }

    /** 内部类实现自定义打印接口 */
    private static class DefaultLogger implements ICustomLogger {

        @Override
        public int v(String tag, String msg) {
            return android.util.Log.v(tag, Log.getContentHeader(msg));
        }

        @Override
        public int v(String tag, String msg, Throwable tr) {
            return android.util.Log.v(tag, Log.getContentHeader(msg), tr);
        }

        @Override
        public int d(String tag, String msg) {
            return android.util.Log.d(tag, Log.getContentHeader(msg));
        }

        @Override
        public int d(String tag, String msg, Throwable tr) {
            return android.util.Log.d(tag, Log.getContentHeader(msg), tr);
        }

        @Override
        public int i(String tag, String msg) {
            return android.util.Log.i(tag, Log.getContentHeader(msg));
        }

        @Override
        public int i(String tag, String msg, Throwable tr) {
            return android.util.Log.i(tag, Log.getContentHeader(msg), tr);
        }

        @Override
        public int w(String tag, String msg) {
            return android.util.Log.w(tag, Log.getContentHeader(msg));
        }

        @Override
        public int w(String tag, String msg, Throwable tr) {
            return android.util.Log.w(tag, Log.getContentHeader(msg), tr);
        }

        @Override
        public int w(String tag, Throwable tr) {
            return android.util.Log.w(tag, tr);
        }

        @Override
        public int e(String tag, String msg) {
            return android.util.Log.e(tag, Log.getContentHeader(msg));
        }

        @Override
        public int e(String tag, String msg, Throwable tr) {
            return android.util.Log.e(tag, Log.getContentHeader(msg), tr);
        }

        @Override
        public int wtf(String tag, Throwable tr) {
            return android.util.Log.wtf(tag, tr);
        }

        @Override
        public int wtf(String tag, String msg) {
            return android.util.Log.wtf(tag, Log.getContentHeader(msg));
        }

        @Override
        public int wtf(String tag, String msg, Throwable tr) {
            return android.util.Log.wtf(tag, Log.getContentHeader(msg), tr);
        }
    }

    /**
     * <h3>自定义Log接口</h3>
     * <br>目的是不需要大幅度修改代码，仅替换导入包即可切换打印工具
     */
    public interface ICustomLogger {

        int v(String tag, String msg);

        int v(String tag, String msg, Throwable tr);

        int d(String tag, String msg);

        int d(String tag, String msg, Throwable tr);

        int i(String tag, String msg);

        int i(String tag, String msg, Throwable tr);

        int w(String tag, String msg);

        int w(String tag, String msg, Throwable tr);

        int w(String tag, Throwable tr);

        int e(String tag, String msg);

        int e(String tag, String msg, Throwable tr);

        int wtf(String tag, Throwable tr);

        int wtf(String tag, String msg);

        int wtf(String tag, String msg, Throwable tr);

    }

}
