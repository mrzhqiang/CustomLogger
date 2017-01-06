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

import com.orhanobut.logger.Logger;

final class LoggerPrint implements IPrint {

    @Override
    public int v(String tag, String msg) {
        Logger.t(tag).v(msg);
        return 0;
    }

    @Override
    public int v(String tag, String msg, Throwable tr) {
        Logger.log(Logger.VERBOSE, tag, msg, tr);
        return 0;
    }

    @Override
    public int d(String tag, String msg) {
        Logger.t(tag).d(msg);
        return 0;
    }

    @Override
    public int d(String tag, String msg, Throwable tr) {
        Logger.log(Logger.DEBUG, tag, msg, tr);
        return 0;
    }

    @Override
    public int i(String tag, String msg) {
        Logger.t(tag).i(msg);
        return 0;
    }

    @Override
    public int i(String tag, String msg, Throwable tr) {
        Logger.log(Logger.INFO, tag, msg, tr);
        return 0;
    }

    @Override
    public int w(String tag, String msg) {
        Logger.t(tag).w(msg);
        return 0;
    }

    @Override
    public int w(String tag, String msg, Throwable tr) {
        Logger.log(Logger.WARN, tag, msg, tr);
        return 0;
    }

    @Override
    public int w(String tag, Throwable tr) {
        Logger.log(Logger.INFO, tag, null, tr);
        return 0;
    }

    @Override
    public int e(String tag, String msg) {
        Logger.t(tag).e(msg);
        return 0;
    }

    @Override
    public int e(String tag, String msg, Throwable tr) {
        Logger.log(Logger.ERROR, tag, msg, tr);
        return 0;
    }

    @Override
    public int wtf(String tag, Throwable tr) {
        Logger.log(Logger.ASSERT, tag, null, tr);
        return 0;
    }

    @Override
    public int wtf(String tag, String msg) {
        Logger.t(tag).wtf(msg);
        return 0;
    }

    @Override
    public int wtf(String tag, String msg, Throwable tr) {
        Logger.log(Logger.ASSERT, tag, msg, tr);
        return 0;
    }
}
