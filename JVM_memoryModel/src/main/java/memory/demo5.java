package memory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.spi.CurrencyNameProvider;

/**
 * @program: JVM
 * @description: 堆内存相关工具
 * @author: Mr.Carl
 **/
public class demo5 {
    //jps查看进程号同top
    //jmap -heap查看堆内存占用情况
    //jconsole可视化界面
    //jvisualvm
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1...");
        Thread.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10]; // 10 Mb
        System.out.println("2...");
        Thread.sleep(20000);
        array = null;
        System.gc();
        System.out.println("3...");
        Thread.sleep(1000000L);
    }
}
