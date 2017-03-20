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

import timber.log.Timber;

/**
 * <p>
 * Created by mrZQ on 2017/3/20.
 */

final class TimberPrint implements IPrint {

    TimberPrint() {
        Timber.uprootAll();
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    public int v(String tag, String msg) {
        Timber.tag(tag).v(msg);
        return 0;
    }

    @Override
    public int v(String tag, String msg, Throwable tr) {
        Timber.tag(tag).v(tr, msg);
        return 0;
    }

    @Override
    public int d(String tag, String msg) {
        Timber.tag(tag).d(msg);
        return 0;
    }

    @Override
    public int d(String tag, String msg, Throwable tr) {
        Timber.tag(tag).d(tr,msg);
        return 0;
    }

    @Override
    public int i(String tag, String msg) {
        Timber.tag(tag).i(msg);
        return 0;
    }

    @Override
    public int i(String tag, String msg, Throwable tr) {
        Timber.tag(tag).i(tr, msg);
        return 0;
    }

    @Override
    public int w(String tag, String msg) {
        Timber.tag(tag).w(msg);
        return 0;
    }

    @Override
    public int w(String tag, String msg, Throwable tr) {
        Timber.tag(tag).w(tr, msg);
        return 0;
    }

    @Override
    public int w(String tag, Throwable tr) {
        Timber.tag(tag).w(tr);
        return 0;
    }

    @Override
    public int e(String tag, String msg) {
        Timber.tag(tag).e(msg);
        return 0;
    }

    @Override
    public int e(String tag, String msg, Throwable tr) {
        Timber.tag(tag).e(tr, msg);
        return 0;
    }

    @Override
    public int wtf(String tag, Throwable tr) {
        Timber.tag(tag).wtf(tr);
        return 0;
    }

    @Override
    public int wtf(String tag, String msg) {
        Timber.tag(tag).wtf(msg);
        return 0;
    }

    @Override
    public int wtf(String tag, String msg, Throwable tr) {
        Timber.tag(tag).wtf(tr, msg);
        return 0;
    }
}
