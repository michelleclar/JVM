package gc;

import java.util.ArrayList;

/**
 * @program: JVM
 * @description: 内存分配策略
 * TODO:
 *      堆:
 *          新生代:minor gc
 *              伊甸园区:对象最开始诞生的地方
 *              幸存区(from):伊甸园中存活的对象
 *              幸存区(to):用来存放幸存下来的对象(不过每次都会进行交换位置,一般to都是空的)复制算法的实现
 *          老年代:存放有价值的对象(用的多的,有引用关系)达到阈值一定会晋升到老年代,只有full gc才会对老年代进行回收
 *      元空间:存储类元信息,class,classload,常量池(串池在1.8之后存放在堆中)
 *
 *
 * @author: Mr.Carl
 **/
public class demo5 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -XX:-ScavengeBeforeFullGC
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }).start();

        System.out.println("sleep....");
        Thread.sleep(1000L);
    }
}
