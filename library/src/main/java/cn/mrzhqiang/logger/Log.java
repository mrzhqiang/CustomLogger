package cn.mrzhqiang.logger;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class Log {
    private static final String LOG_NAME = Log.class.getName();
    private static final int CHUNK_SIZE = 4000;
    private static final int MAX_TAG_SIZE = 23;

    private static boolean showD = true;

    private Log() { throw new AssertionError("No instance."); }

    public static void debug(boolean showD) {
        Log.showD = showD;
    }

    public static void v(@Nullable String tag, @Nullable String content) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.v(TAG, message);
        }
    }

    public static void v(@Nullable String tag, @Nullable String content, @NonNull Throwable tr) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.v(TAG, message);
        }
        android.util.Log.v(TAG, "", tr);
    }

    public static void i(@Nullable String tag, @Nullable String content) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.i(TAG, message);
        }
    }

    public static void i(@Nullable String tag, @Nullable String content, @NonNull Throwable tr) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.i(TAG, message);
        }
        android.util.Log.i(TAG, "", tr);
    }

    public static void wtf(@Nullable String tag, @Nullable String content) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.wtf(TAG, message);
        }
    }

    public static void wtf(@Nullable String tag, @NonNull Throwable tr) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg("");
        for (String message : MSG) {
            android.util.Log.wtf(TAG, message);
        }
        android.util.Log.wtf(TAG, tr);
    }

    public static void wtf(@Nullable String tag, @Nullable String content, @NonNull Throwable tr) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.wtf(TAG, message);
        }
        android.util.Log.wtf(TAG, "", tr);
    }

    public static void e(@Nullable String tag, @Nullable String content) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.e(TAG, message);
        }
    }

    public static void e(@Nullable String tag, @Nullable String content, @NonNull Throwable tr) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.e(TAG, message);
        }
        android.util.Log.e(TAG, "", tr);
    }

    public static void w(@Nullable String tag, @Nullable String content) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.w(TAG, message);
        }
    }

    public static void w(@Nullable String tag, @NonNull Throwable tr) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg("");
        for (String message : MSG) {
            android.util.Log.w(TAG, message);
        }
        android.util.Log.w(TAG, tr);

    }

    public static void w(@Nullable String tag, @Nullable String content, @NonNull Throwable tr) {
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.w(TAG, message);
        }
        android.util.Log.w(TAG, "", tr);
    }

    public static void d(@Nullable String tag, @Nullable String content) {
        if (!showD) { return; }
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.d(TAG, message);
        }
    }

    public static void d(@Nullable String tag, @Nullable String content, @NonNull Throwable tr) {
        if (!showD) { return; }
        String TAG = checkTag(tag);
        List<String> MSG = checkMsg(content);
        for (String message : MSG) {
            android.util.Log.d(TAG, message);
        }
        android.util.Log.d(TAG, "", tr);
    }

    public static void p(@Nullable String tag, @Nullable String content) {
        if (!showD) { return; }
        android.util.Log.d(tag, content);
    }

    public static void p(@Nullable String tag, @Nullable String content, @NonNull Throwable tr) {
        if (!showD) { return; }
        android.util.Log.d(tag, content, tr);
    }

    private static String checkTag(String tag) {
        if (tag != null) {
            return tag.length() > MAX_TAG_SIZE ? tag.substring(0, MAX_TAG_SIZE) : tag;
        }
        return LOG_NAME;
    }

    private static List<String> checkMsg(String msg) {
        if (msg == null) { msg = ""; }

        List<String> msgList = new ArrayList<>();

        long msgLength = msg.length();
        if (msgLength > CHUNK_SIZE) {
            // Split by line, then ensure each line can fit into Log's maximum length.
            for (int i = 0, length = msg.length(); i < length; i++) {
                int newline = msg.indexOf('\n', i);
                newline = newline != -1 ? newline : length;
                do {
                    int end = Math.min(newline, i + CHUNK_SIZE);
                    String part = msg.substring(i, end);
                    msgList.add(part);
                    i = end;
                }
                while (i < newline);
            }
        } else {
            msgList.add(msg);
        }
        return msgList;
    }

//    private static int getCallerIndex(StackTraceElement[] trace) {
//        for (int i = 2; i < trace.length; i++) {
//            StackTraceElement e = trace[i];
//            String name = e.getClassName();
//            if (!LOG_NAME.equals(name)) {
//                return i;
//            }
//        }
//        return 2;
//    }

}
