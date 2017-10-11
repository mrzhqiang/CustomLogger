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

package cn.mrzhqiang.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.mrzhqiang.logger.BuildConfig;
import cn.mrzhqiang.logger.Log;

/**
 * 日志使用样例
 * <p>
 * Created by mrZQ on 2016/11/01.
 */
public class SampleLoggerActivity extends AppCompatActivity {

    private static final String TAG = "SampleLoggerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_logger);
        // 说明Log的使用方法，关于第三方日志工具，可以在这里找到：
        // https://github.com/orhanobut/logger.git
        // https://github.com/JakeWharton/timber.git

        // 使用DEBUG常量控制日志debug开关
        // 注意，不能用Library模块下的这个常量，因为它总是false（release类型）
        Log.debug(BuildConfig.DEBUG);
        // 用这个才是正确的
        Log.debug(cn.mrzhqiang.sample.BuildConfig.DEBUG);
        // 后续的使用与系统Log完全一样
        Log.d(TAG, "调试日志");
        Log.e(TAG, "错误日志", new RuntimeException("no thk."));
    }

}