# debug-log
### debug-log是什么？
- 针对系统日志的一个兼容类
- TAG限定在23个字符以内
- content约3000时自动换行，以免丢失相关信息
- 使用Log.debug(true/false)控制debug日志输出
- 传null的TAG默认使用简单类名（Log）
### 怎么取得依赖？
~~~
// 根目录
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
   
// 需要依赖的工程
dependencies {
  compile 'com.github.mrzhqiang:debug-log:1.1'
}
~~~
