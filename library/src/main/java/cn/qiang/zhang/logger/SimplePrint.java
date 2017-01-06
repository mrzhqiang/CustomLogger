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
		// 得到当前方法的堆栈信息对象数组
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		// 从数组中得到调用Log工具的类和方法下标位置
		int currentIndex = getCallerIndex(trace);
		// 如果下标越界，直接返回消息
		if (currentIndex < 0 || currentIndex >= trace.length) {
			return msg;
		}
		String message = msg;
		try {
			// 取得调用者信息: Class.Method(FileName:LineNumber)
			StackTraceElement ste = trace[currentIndex];
			// 格式化相关信息
			message = String.format(Locale.getDefault(),
			                        CONTENT_FORMAT,
			                        getSimpleClassName(ste.getClassName()),
			                        ste.getMethodName(),
			                        ste.getFileName(),
			                        ste.getLineNumber(),
			                        message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] bytes = message.getBytes();
		int length = bytes.length;
		if (length > CHUNK_SIZE) {
			System.out.println("===content oversize >4000 bytes system.out.println===");
			System.out.println("||");
			System.out.println("||");
			for (int i = 0; i < length; i += CHUNK_SIZE) {
				int count = Math.min(length - i, CHUNK_SIZE);
				//create a new String with system's default charset (which is UTF-8 for Android)
				message = new String(bytes, i, count);
				String[] lines = message.split(System.getProperty("line.separator"));
				for (String line : lines) {
					System.out.println(line);
				}
			}
			System.out.println("||");
			System.out.println("||");
			return "===content oversize >4000 bytes system.out.println===";
		}
		return message;
	}

	/**
	 * 获取方法调用者的位置信息
	 * @param trace 日志打印时的堆栈信息
	 * @return 调用者处于堆栈的下标位置
	 */
	private static int getCallerIndex(StackTraceElement[] trace) {
		// 从下标位置2开始，忽略前面两个堆栈信息
		for (int i = 2; i < trace.length; i++) {
			StackTraceElement e = trace[i];
			String name = e.getClassName();
			// 忽略内部调用信息
			if (!name.equals(SimplePrint.class.getName())
					&& !name.equals(IPrint.class.getName())
					&& !name.equals(Log.class.getName())) {
				// 返回调用Log方法信息的下标位置
				return i;
			}
		}
		// 这里通常不起作用，给一个初始化值即可
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
