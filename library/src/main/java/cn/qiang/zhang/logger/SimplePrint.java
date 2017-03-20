/*
 * Copyright (c) 2017.  mrZQ
 *
 * icensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package cn.qiang.zhang.logger;

import java.util.Locale;

/**
 * 默认打印接口实现：简单、干净、方便寻找问题根源
 * <p>
 * Created by mrZQ on 2016/12/31.
 */

final class SimplePrint implements IPrint {

    /** [Class.Method(Filename:Line)] ==>> Message */
    private final static String CONTENT_FORMAT = " [%s.%s(%s:%d)] ==>> %s";
    private static final int CHUNK_SIZE = 4000;

    /**
     * 获取打印头：即显示——类.方法(行数)
     * @param msg content
     * @return class.method(line) content
     */
    private static String getContentHeader(String msg) {
        if (msg == null) {
            msg = "";
        }

        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        int currentIndex = getCallerIndex(trace);
        if (currentIndex < 0 || currentIndex >= trace.length) {
            return msg;
        }

        StackTraceElement ste = trace[currentIndex];

        if (msg.length() < CHUNK_SIZE) {
            String message = msg;
            try {
                message = String.format(Locale.getDefault(), CONTENT_FORMAT,
                                        getSimpleClassName(ste.getClassName()),
                                        ste.getMethodName(),
                                        ste.getFileName(),
                                        ste.getLineNumber(),
                                        message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return message;
        } else {
            String message = String.format(Locale.getDefault(), CONTENT_FORMAT,
                                           getSimpleClassName(ste.getClassName()),
                                           ste.getMethodName(),
                                           ste.getFileName(),
                                           ste.getLineNumber(),
                                           "");
            android.util.Log.v("===Split===", message);

            // Split by line, then ensure each line can fit into Log's maximum length.
            for (int i = 0, length = msg.length(); i < length; i++) {
                int newline = msg.indexOf('\n', i);
                newline = newline != -1 ? newline : length;
                do {
                    int end = Math.min(newline, i + CHUNK_SIZE);
                    String part = msg.substring(i, end);
                    android.util.Log.v("===Split===", part);
                    i = end;
                } while (i < newline);
            }
            return message + "===Split===";
        }
    }

    /**
     * 获取方法调用者的位置信息
     * @param trace 日志打印时的堆栈信息
     * @return 调用者处于堆栈的下标位置
     */
    private static int getCallerIndex(StackTraceElement[] trace) {
        for (int i = 2; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(SimplePrint.class.getName())
                    && !name.equals(IPrint.class.getName())
                    && !name.equals(Log.class.getName())) {
                return i;
            }
        }
        return 2;
    }

    /**
     * 获取类名——简单方式
     * @param name 详细类名
     * @return 简单类名
     */
    private static String getSimpleClassName(String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }

    @Override
    public int v(String tag, String msg) {
        return android.util.Log.v(tag, getContentHeader(msg));
    }

    @Override
    public int v(String tag, String msg, Throwable tr) {
        return android.util.Log.v(tag, getContentHeader(msg), tr);
    }

    @Override
    public int d(String tag, String msg) {
        return android.util.Log.d(tag, getContentHeader(msg));
    }

    @Override
    public int d(String tag, String msg, Throwable tr) {
        return android.util.Log.d(tag, getContentHeader(msg), tr);
    }

    @Override
    public int i(String tag, String msg) {
        return android.util.Log.i(tag, getContentHeader(msg));
    }

    @Override
    public int i(String tag, String msg, Throwable tr) {
        return android.util.Log.i(tag, getContentHeader(msg), tr);
    }

    @Override
    public int w(String tag, String msg) {
        return android.util.Log.w(tag, getContentHeader(msg));
    }

    @Override
    public int w(String tag, String msg, Throwable tr) {
        return android.util.Log.w(tag, getContentHeader(msg), tr);
    }

    @Override
    public int w(String tag, Throwable tr) {
        return android.util.Log.w(tag, tr);
    }

    @Override
    public int e(String tag, String msg) {
        return android.util.Log.e(tag, getContentHeader(msg));
    }

    @Override
    public int e(String tag, String msg, Throwable tr) {
        return android.util.Log.e(tag, getContentHeader(msg), tr);
    }

    @Override
    public int wtf(String tag, Throwable tr) {
        return android.util.Log.wtf(tag, tr);
    }

    @Override
    public int wtf(String tag, String msg) {
        return android.util.Log.wtf(tag, getContentHeader(msg));
    }

    @Override
    public int wtf(String tag, String msg, Throwable tr) {
        return android.util.Log.wtf(tag, getContentHeader(msg), tr);
    }

}
