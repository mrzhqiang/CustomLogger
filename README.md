# CustomLogger
对第三方日志工具与系统日志工具的一个适配方案，内部提供简单的格式化打印样例。
### 怎样使用？
- 添加依赖
```
// 根目录
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}

// 需要依赖的工程
dependencies {
        compile 'com.github.mrzhqiang:CustomLogger:1.3'
}
```
- 输出日志
```
// 类似Android系统日志，另带有简单参数
// Log.d/e/w/i/v/wtf(TAG, message);
Log.d(TAG, "系统日志");
Log.d("简单日志将输出默认的统一TAG");
Log.customTag(true); // 表示输出传入的TAG，否则将输出默认TAG
Log.debug(false/true); // true为默认打印；false表示屏蔽打印
// 目前版本将Line改为File.Line，即可以随时追踪输出日志的位置，类似异常消息定位
// 比如：SampleLoggerActivity.java:30

// 2017/03/20 change
// 增加对Timber的接口
```
#### 其他自定义接口替换打印工具，请参见[sample](https://github.com/mrzhqiang/CustomLogger/tree/master/sample)。
