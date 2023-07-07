package com.cy.java.basic;

import java.util.ArrayList;
import java.util.List;
/**JVM 参数
 * 1)GC参数: -XX:+PrintGC  (程序运行过程中输出GC相关信息)
 * 2)堆(Heap)参数:-Xmx(最大堆) -Xms(最小堆)
 * 例如:设置JVM运行时的堆大小
 * -Xmx20m -Xms20m
 * 3)监控类加载顺序参数:-XX:+TraceClassLoading
 * */
public class HelloWorld {
    public static void main(String[] args) {

        //System.out.println("HelloWorld");
        System.out.println(args[0]);
        List<byte[]> list=new ArrayList<>();
        for(int i=0;i<1000;i++){
            list.add(new byte[1024*1024]);
        }
        System.out.println("finish");
    }
}
