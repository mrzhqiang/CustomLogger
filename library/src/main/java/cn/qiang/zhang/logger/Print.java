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

import android.text.TextUtils;

import java.util.Locale;

import static cn.qiang.zhang.logger.Setting.CONTENT_FORMAT;
import static cn.qiang.zhang.logger.Setting.DEFAULT_TAG;

/**
 * 打印
 * <p>
 * Created by mrZQ on 2016/12/11.
 */

final class Print {

	static final IPrint print = new IPrint() {

		@Override
		public int v(String tag, String msg) {
			return android.util.Log.v(tag(tag), getContentHeader(msg));
		}

		@Override
		public int v(String tag, String msg, Throwable tr) {
			return android.util.Log.v(tag(tag), getContentHeader(msg), tr);
		}

		@Override
		public int d(String tag, String msg) {
			return android.util.Log.d(tag(tag), getContentHeader(msg));
		}

		@Override
		public int d(String tag, String msg, Throwable tr) {
			return android.util.Log.d(tag(tag), getContentHeader(msg), tr);
		}

		@Override
		public int i(String tag, String msg) {
			return android.util.Log.i(tag(tag), getContentHeader(msg));
		}

		@Override
		public int i(String tag, String msg, Throwable tr) {
			return android.util.Log.i(tag(tag), getContentHeader(msg), tr);
		}

		@Override
		public int w(String tag, String msg) {
			return android.util.Log.w(tag(tag), getContentHeader(msg));
		}

		@Override
		public int w(String tag, String msg, Throwable tr) {
			return android.util.Log.w(tag(tag), getContentHeader(msg), tr);
		}

		@Override
		public int w(String tag, Throwable tr) {
			return android.util.Log.w(tag(tag), tr);
		}

		@Override
		public int e(String tag, String msg) {
			return android.util.Log.e(tag(tag), getContentHeader(msg));
		}

		@Override
		public int e(String tag, String msg, Throwable tr) {
			return android.util.Log.e(tag(tag), getContentHeader(msg), tr);
		}

		@Override
		public int wtf(String tag, Throwable tr) {
			return android.util.Log.wtf(tag(tag), tr);
		}

		@Override
		public int wtf(String tag, String msg) {
			return android.util.Log.wtf(tag(tag), getContentHeader(msg));
		}

		@Override
		public int wtf(String tag, String msg, Throwable tr) {
			return android.util.Log.wtf(tag(tag), getContentHeader(msg), tr);
		}

	};

	/**
	 * @return 默认标签，如果清空，返回当前类名
	 */
	static String tag() {
		return TextUtils.isEmpty(DEFAULT_TAG)
				? Print.class.getSimpleName()
				: DEFAULT_TAG;
	}

	/**
	 * @param tag 用户传入标签
	 * @return 如果用户决定自定义标签，返回传入的标签，否则使用默认标签
	 */
	private static String tag(String tag) {
		return Setting.isCustomTag ? tag : tag();
	}

	/**
	 * 获取打印消息的最开始部分：即显示——类.方法(行数)
	 * @param msg content
	 * @return class.method(line) content
	 */
	private static String getContentHeader(String msg) {
		String message = msg;
		// 得到当前方法的堆栈信息对象数组
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		// 从数组中得到调用当前方法的（类.方法）下标
		int currentIndex = getCallerIndex(trace);
		// 如果下标越界，返回错误信息
		if (currentIndex < 0 || currentIndex >= trace.length) {
			return "Can not find classed and methods of information !\n" + message;
		}
		try {
			message = String.format(Locale.getDefault(),
					CONTENT_FORMAT,
					getSimpleClassName(trace[currentIndex].getClassName()),
					trace[currentIndex].getMethodName(),
					trace[currentIndex].getLineNumber(),
					message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
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
			if (!name.equals(print.getClass().getName())
					&& !name.equals(Print.class.getName())
					&& !name.equals(Log.class.getName())) {
				return i;
			}
		}
		return -1;
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

}
