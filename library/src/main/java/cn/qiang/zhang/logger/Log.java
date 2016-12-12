/*
 *
 *    Copyright 2016 mrZQ
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */
package cn.qiang.zhang.logger;

import com.orhanobut.logger.Logger;

/**
 * 格式化日志打印
 * <p>
 * 通过适配的接口，将{@link android.util.Log 系统日志打印工具}替换为格式内容日志工具<br>
 * 其中，json、xml、Map、List、Set等对象，推荐使用{@link Logger 第三方日志打印工具}<br>
 * 基本内容最好使用自定义工具打印——1.完全兼容系统日志工具；2.精简所需信息；3.替换只需要修改导入包<br>
 * <p>
 * Created by mrZQ on 2016/10/13.
 */

public final class Log {

	private Log() {/* no instance */}

	/**
	 * 简易调试打印
	 * @param content 调试消息内容
	 */
	public static void d(String content) {
		if (!Setting.showD) return;
		Setting.mLogger.d(Print.tag(), content);
	}

	/**
	 * 系统相关的调试打印1
	 * @param tag     标签
	 * @param content 调试消息内容
	 */
	public static void d(String tag, String content) {
		if (!Setting.showD) return;
		Setting.mLogger.d(tag, content);
	}

	/**
	 * 系统相关的调试打印2
	 * @param tag     标签
	 * @param content 调试消息内容
	 * @param tr      堆栈
	 */
	public static void d(String tag, String content, Throwable tr) {
		if (!Setting.showD) return;
		Setting.mLogger.d(tag, content, tr);
	}

	/**
	 * 简易错误打印
	 * @param content 错误消息内容
	 */
	public static void e(String content) {
		if (!Setting.showE) return;
		Setting.mLogger.e(Print.tag(), content);
	}

	/**
	 * 系统相关的错误打印1
	 * @param tag     标签
	 * @param content 错误消息内容
	 */
	public static void e(String tag, String content) {
		if (!Setting.showE) return;
		Setting.mLogger.e(tag, content);
	}

	/**
	 * 系统相关的错误打印2
	 * @param tag     标签
	 * @param content 错误消息内容
	 * @param tr      堆栈
	 */
	public static void e(String tag, String content, Throwable tr) {
		if (!Setting.showE) return;
		Setting.mLogger.e(tag, content, tr);
	}

	/**
	 * 简易信息打印
	 * @param content 相关消息内容
	 */
	public static void i(String content) {
		if (!Setting.showI) return;
		Setting.mLogger.i(Print.tag(), content);
	}

	/**
	 * 系统相关的信息打印1
	 * @param tag     标签
	 * @param content 相关消息内容
	 */
	public static void i(String tag, String content) {
		if (!Setting.showI) return;
		Setting.mLogger.i(tag, content);
	}

	/**
	 * 系统相关的信息打印2
	 * @param tag     标签
	 * @param content 相关消息内容
	 * @param tr      堆栈
	 */
	public static void i(String tag, String content, Throwable tr) {
		if (!Setting.showI) return;
		Setting.mLogger.i(tag, content, tr);
	}

	/**
	 * 简易详情打印
	 * @param content 详情消息内容
	 */
	public static void v(String content) {
		if (!Setting.showV) return;
		Setting.mLogger.v(Print.tag(), content);
	}

	/**
	 * 系统相关的详情打印1
	 * @param tag     标签
	 * @param content 详情消息内容
	 */
	public static void v(String tag, String content) {
		if (!Setting.showV) return;
		Setting.mLogger.v(tag, content);
	}

	/**
	 * 系统相关的详情打印2
	 * @param tag     标签
	 * @param content 详情消息内容
	 * @param tr      堆栈
	 */
	public static void v(String tag, String content, Throwable tr) {
		if (!Setting.showV) return;
		Setting.mLogger.v(tag, content, tr);
	}

	/**
	 * 简易警告打印
	 * @param content 警告消息内容
	 */
	public static void w(String content) {
		if (!Setting.showW) return;
		Setting.mLogger.w(Print.tag(), content);
	}

	/**
	 * 系统相关的警告打印1
	 * @param tag     标签
	 * @param content 警告消息内容
	 */
	public static void w(String tag, String content) {
		if (!Setting.showW) return;
		Setting.mLogger.w(tag, content);
	}

	/**
	 * 系统相关的警告打印2
	 * @param tag 标签
	 * @param tr  堆栈
	 */
	public static void w(String tag, Throwable tr) {
		if (!Setting.showW) return;
		Setting.mLogger.w(tag, tr);
	}

	/**
	 * 系统相关的警告打印3
	 * @param tag     标签
	 * @param content 警告消息内容
	 * @param tr      堆栈
	 */
	public static void w(String tag, String content, Throwable tr) {
		if (!Setting.showW) return;
		Setting.mLogger.w(tag, content, tr);
	}

	/**
	 * 简易诡异打印
	 * @param content 诡异消息内容
	 */
	public static void wtf(String content) {
		if (!Setting.showWtf) return;
		Setting.mLogger.wtf(Print.tag(), content);
	}

	/**
	 * 系统相关的诡异打印1
	 * @param tag     标签
	 * @param content 诡异消息内容
	 */
	public static void wtf(String tag, String content) {
		if (!Setting.showWtf) return;
		Setting.mLogger.wtf(tag, content);
	}

	/**
	 * 系统相关的诡异打印2
	 * @param tag 标签
	 * @param tr  堆栈
	 */
	public static void wtf(String tag, Throwable tr) {
		if (!Setting.showWtf) return;
		Setting.mLogger.wtf(tag, tr);
	}

	/**
	 * 系统相关的诡异打印3
	 * @param tag     标签
	 * @param content 诡异消息内容
	 * @param tr      堆栈
	 */
	public static void wtf(String tag, String content, Throwable tr) {
		if (!Setting.showWtf) return;
		Setting.mLogger.wtf(tag, content, tr);
	}

	/**
	 * @param isCustomTag ture 表示自定义TAG；false 表示预定义TAG，默认
	 */
	public static void customTag(boolean isCustomTag) {
		Setting.isCustomTag = isCustomTag;
	}

	/**
	 * @param showD true 开启调试日志，默认；false 关闭调试日志
	 */
	public static void debug(boolean showD) {
		Setting.showD = showD;
	}

	/**
	 * @param showE true 开启错误日志，默认；false 关闭错误日志
	 */
	public static void error(boolean showE) {
		Setting.showE = showE;
	}

	/**
	 * @param showW true 开启警告日志，默认；false 关闭警告日志
	 */
	public static void warn(boolean showW) {
		Setting.showW = showW;
	}

	/**
	 * @param mLogger 自定义日志打印接口
	 */
	public static void setLogger(IPrint mLogger) {
		if (mLogger == null) {
			throw new NullPointerException("IPrint is null");
		}
		Setting.mLogger = mLogger;
	}

}
