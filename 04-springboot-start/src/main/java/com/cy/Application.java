package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 您知道springboot项目在启动时做了什么吗?
 * 1)从磁盘中指定位置(classpath)将类读到内存(JDK基础类库优先,spring内部类库),
 *  可以基于JVM类加载参数进行分析(-XX:+TraceClassLoading)
 * 2)读取类的配置信息(来自类的注解或者是配置文件),并基于对象存储配置信息
 * 3)基于配置初始化spring资源并创建其相关bean的实例进行存储和管理
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
