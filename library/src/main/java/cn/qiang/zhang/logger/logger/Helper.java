package cn.qiang.zhang.logger.logger;

import android.support.annotation.Nullable;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/**
 * <h3>
 * 日志辅助类
 * </h3><br>
 * 避免对Android方法的依赖，减少工具出现异常的因素。
 * <p>
 * Created by mrZQ on 2016/10/12.
 */
public final class Helper {

    /** 隐藏构造方法 */
    private Helper() {
        // Hidden constructor.
    }

    /** 判断传入的字符序列是否为空（空的意义，即null对象或长度为0） */
    public static boolean isEmpty(@Nullable CharSequence str) {
        return str == null || str.length() == 0;
    }

    /** 判断两个字符序列是否相等 */
    public static boolean equals(CharSequence a, CharSequence b) {
        // 同一个字符序列对象的引用
        if (a == b) return true;
        int length;
        // a和b都不为null，且长度一致时
        if (a != null && b != null && (length = a.length()) == b.length()) {
            // 进一步辨认是否为String类，即字符串
            if (a instanceof String && b instanceof String) {
                // 调用字符串比较方法去返回状态
                return a.equals(b);
            } else {
                // 非字符串对象，则逐一对比字符，稍有不一致返回false
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) return false;
                }
                // 完全一致
                return true;
            }
        }
        // 长度不一致，或有一个为null
        return false;
    }

    /**
     * 复制{@link Log#getStackTraceString(Throwable)}是为了避免在单元测试中使用Android堆栈
     * 原方法注释：Handy function to get a loggable stack trace from a Throwable
     * @param tr An exception to log 一个异常日志记录
     * @return Stack trace in form of String 堆栈跟踪形式的字符串
     */
    public static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }

        // This is to reduce the amount of log spew that apps do in the non-error
        // condition of the network being unavailable.
        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }
}
