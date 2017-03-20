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
 * 设置
 * <p>
 * Created by mrZQ on 2016/12/11.
 */

final class Setting {

    /** 标签 */
    static final String DEFAULT_TAG = "Log";

    static boolean showV = true;
    static boolean showD = true;
    static boolean showI = true;
    static boolean showW = true;
    static boolean showE = true;
    static boolean showWtf = true;

    /** 是否开启自定义标签，true 传值标签；false 固定标签 */
    static boolean isCustomTag = false;

    private Setting() {/*no instance*/}

}
