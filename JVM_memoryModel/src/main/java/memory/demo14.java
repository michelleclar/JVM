package memory;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;


/**
 * @program: JVM
 * @description: 直接内存的空间释放
 * 底层使用Unsafe实现,虚引用
 * @author: Mr.Carl
 **/
public class demo14 {
    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Unsafe unsafe = getUnsafe();
        // 分配内存
        long base = unsafe.allocateMemory(_1Gb);//返回内存地址
        unsafe.setMemory(base, _1Gb, (byte) 0);
        System.in.read();

        // 释放内存
        unsafe.freeMemory(base);
        System.in.read();
    }

    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
//    static int _1Gb = 1024 * 1024 * 1024;
//
//    /*
//     * -XX:+DisableExplicitGC 显式的
//     */
//    public static void main(String[] args) throws IOException {
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
//        System.out.println("分配完毕...");
//        System.in.read();
//        System.out.println("开始释放...");
//        byteBuffer = null;
//        System.gc(); // 显式的垃圾回收，Full GC
//        System.in.read();
//    }


