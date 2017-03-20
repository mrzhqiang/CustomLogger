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

/**
 * 日志打印入口，默认简单打印，可以替换为Logger或Timber。
 * <p>
 * Created by mrZQ on 2016/10/13.
 */
public final class Log {

    private static final IPrint DEFAULT = new SimplePrint();
    private static final int MAX_TAG_SIZE = 23;

    private static IPrint mLogger = DEFAULT;

    private Log() {/* no instance */}

    public static void d(String content) {
        if (!Setting.showD) return;
        getLogger().d(tag(), content);
    }

    public static void d(String tag, String content) {
        if (!Setting.showD) return;
        getLogger().d(tag(tag), content);
    }

    public static void d(String tag, String content, Throwable tr) {
        if (!Setting.showD) return;
        getLogger().d(tag(tag), content, tr);
    }

    public static void e(String content) {
        if (!Setting.showE) return;
        getLogger().e(tag(), content);
    }

    public static void e(String tag, String content) {
        if (!Setting.showE) return;
        getLogger().e(tag(tag), content);
    }

    public static void e(String tag, String content, Throwable tr) {
        if (!Setting.showE) return;
        getLogger().e(tag(tag), content, tr);
    }

    public static void i(String content) {
        if (!Setting.showI) return;
        getLogger().i(tag(), content);
    }

    public static void i(String tag, String content) {
        if (!Setting.showI) return;
        getLogger().i(tag(tag), content);
    }

    public static void i(String tag, String content, Throwable tr) {
        if (!Setting.showI) return;
        getLogger().i(tag(tag), content, tr);
    }

    public static void v(String content) {
        if (!Setting.showV) return;
        getLogger().v(tag(), content);
    }

    public static void v(String tag, String content) {
        if (!Setting.showV) return;
        getLogger().v(tag(tag), content);
    }

    public static void v(String tag, String content, Throwable tr) {
        if (!Setting.showV) return;
        getLogger().v(tag(tag), content, tr);
    }

    public static void w(String content) {
        if (!Setting.showW) return;
        getLogger().w(tag(), content);
    }

    public static void w(String tag, String content) {
        if (!Setting.showW) return;
        getLogger().w(tag(tag), content);
    }

    public static void w(String tag, Throwable tr) {
        if (!Setting.showW) return;
        getLogger().w(tag(tag), tr);
    }

    public static void w(String tag, String content, Throwable tr) {
        if (!Setting.showW) return;
        getLogger().w(tag(tag), content, tr);
    }

    public static void wtf(String content) {
        if (!Setting.showWtf) return;
        getLogger().wtf(tag(), content);
    }

    public static void wtf(String tag, String content) {
        if (!Setting.showWtf) return;
        getLogger().wtf(tag(tag), content);
    }

    public static void wtf(String tag, Throwable tr) {
        if (!Setting.showWtf) return;
        getLogger().wtf(tag(tag), tr);
    }

    public static void wtf(String tag, String content, Throwable tr) {
        if (!Setting.showWtf) return;
        getLogger().wtf(tag(tag), content, tr);
    }

    /** @param isCustomTag ture 表示自定义TAG；false 表示预定义TAG，默认 */
    public static void customTag(boolean isCustomTag) {
        Setting.isCustomTag = isCustomTag;
    }

    /** @param showD true 开启调试日志，默认；false 关闭调试日志 */
    public static void debug(boolean showD) {
        Setting.showD = showD;
    }

    /** 获取打印接口实例 */
    public static IPrint getLogger() {
        return mLogger == null ? mLogger = DEFAULT : mLogger;
    }

    /** 自定义日志打印接口 */
    public static void setLogger(IPrint customLogger) {
        mLogger = customLogger == null ? DEFAULT : customLogger;
    }

    /** 设置漂亮的打印接口 */
    @SuppressWarnings("unused")
    public static void pretty() {
        setLogger(new LoggerPrint());
    }

    /** 设置灵魂之树的打印接口 */
    @SuppressWarnings("unused")
    public static void timber() {
        setLogger(new TimberPrint());
    }

    /** 使用固定tag，用于没有tag参数的方法 */
    private static String tag() {
        return Setting.DEFAULT_TAG;
    }

    /** 内部判断是否使用固定tag */
    private static String tag(String tag) {
        if (Setting.isCustomTag && tag != null) {
            return tag.length() > MAX_TAG_SIZE ? tag.substring(0, MAX_TAG_SIZE) : tag;
        }
        return Setting.DEFAULT_TAG;
    }

}
