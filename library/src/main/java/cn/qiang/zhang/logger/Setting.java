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

/**
 * 设置
 * <p>
 * Created by mrZQ on 2016/12/11.
 */

final class Setting {

	/** 标签 */
	static final String DEFAULT_TAG = "mrZQ";
	/** 内容格式 [Main.print(L:100)] ==>> 打印内容 */
	static final String CONTENT_FORMAT = " [%s.%s(L:%d)] ==>> %s";
	/** 打印接口 */
	static IPrint mLogger = Print.print;
	/** 测试开关，Verbose */
	static boolean showV = true;
	/** 测试开关，Debug */
	static boolean showD = true;
	/** 测试开关，Info */
	static boolean showI = true;
	/** 测试开关，Warn */
	static boolean showW = true;
	/** 测试开关，Error */
	static boolean showE = true;
	/** 测试开关，What the fuck */
	static boolean showWtf = true;
	/** 是否使用自定义标签 */
	static boolean isCustomTag = false;

	private Setting() {
		// no instance
	}

}
