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

package cn.qiang.zhang.customlogger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import cn.qiang.zhang.logger.Log;

/**
 * 兼容方案，第三方日志工具与系统工具轻松转换，样例
 * <p>
 * 这里将展示兼容工具的使用方法，显而易见的是，无论是怎样的工具，都为了方便使用而创造。<br>
 * 多线程环境下可能无法保持既有的显示顺序，且不论如何在最后总是调用系统日志工具{@link android.util.Log}。
 * 因此，所谓的第三方日志工具与当前兼容工具，仅为了美观或条目清晰而存在。
 * <p>
 * Created by mrZQ on 2016/11/01.
 */
public class SampleLoggerActivity extends AppCompatActivity {

	private static final String TAG = "SampleLoggerActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_logger);
		// 说明Log的使用方法，关于第三方日志工具，可以在这里找到：https://github.com/orhanobut/logger
		explainLog();
	}

	/**
	 * 在这里，将讲述如何使用Log日志兼容工具
	 */
	private void explainLog() {
	    /*logger*/
		// 1 使用Logger需要这样做
		Log.pretty();
		// 3 json
		Logger.json("{json:这是json格式吗？}");
		// 4 xml
		Logger.xml("<h3>这是标题</h3>");
		// 5.Log.d
		Log.d("Logger适配成功");
		// 6.简单日志
		Log.setLogger(null);

		/*Log*/
		// 1 设置使用自定义tag
		Log.customTag(true);
		// 2 打印
		Log.d(TAG, "打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG\n头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG\n头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印\nTAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG\n头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TA\nG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打\n印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG\n头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TA\nG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG\n头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印T\nAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG\n头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TA\nG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TA\nG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TA\nG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打\n印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头\n打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头"+
				"打印TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印" +
				"TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打" +
				"印TAG头打印TAG头打印TAG头打印TAG头打印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头印TAG头打印TAG头打印\nTAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头印T\nAG头打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头" +
				"打印TAG头打印TAG头打印TAG头打印TAG头打印TAG头");
	}

}