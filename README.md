# CustomLogger
对第三方日志工具与系统日志工具的一个兼容方案，相当于连接桥梁，在不破坏代码结构的前提下。
### 怎样使用？
- 添加依赖
```
// 根目录下
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
// 需要使用的工程下
dependencies {
        compile 'com.github.mrzhqiang:CustomLogger:1.0'
}
```
- 创建jar包
  > Clone我的工程或下载压缩包到本地，找到Library模块下的libs目录，复制CustomLogger.jar文件到工程目录下，或你喜欢的任何位置——只要依赖这个包就行。

  > 假设libs目录下没有.jar文件，此分支生效：a.通过AS打开这个工程，使用Gradle运行：Library模块other目录下的makeJar命令；b.得到Successful提示，去找到libs目录下的CustomLogger.jar即可。

依赖成功后，在你的自定义application类的onCreate方法初始化Log.initCustomLogger，这样保证使用简化的格式化日志输出工具。

#### 其他相关使用方法，请参见Sample。
