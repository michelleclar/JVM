package cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @program: JVM
 * @description: CAS算法原理
 * @author: Mr.Carl
 **/
public class demo1 {

    public static void main(String[] args) throws InterruptedException {
//        // 需要不断尝试
//        while(true) {
//            int 旧值 = 共享变量 ; // 比如拿到了当前值 0
//            int 结果 = 旧值 + 1; // 在旧值 0 的基础上增加 1 ，正确结果是 1
//            /*
//                 这时候如果别的线程把共享变量改成了 5，本线程的正确结果 1 就作废了，这时候
//                    compareAndSwap 返回 false，重新尝试，直到：
//                compareAndSwap 返回 true，表示我本线程做修改的同时，别的线程没有干扰
//                */
//            if( compareAndSwap ( 旧值, 结果 )) {
//            // 成功，退出循环
//            }
//        }

        DataContainer dc = new DataContainer();
        int count = 5;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                dc.increase();
            }
        });
        t1.start();
        t1.join();
        System.out.println(dc.getData());

    }
}

class DataContainer {
    private volatile int data;
    static final Unsafe unsafe;
    static final long DATA_OFFSET;

    static {
        try {
// Unsafe 对象不能直接调用，只能通过反射获得
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
        try {
// data 属性在 DataContainer 对象中的偏移量，用于 Unsafe 直接访问该属性
            DATA_OFFSET =
                    unsafe.objectFieldOffset(DataContainer.class.getDeclaredField("data"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    public void increase() {
        int oldValue;
        while (true) {
// 获取共享变量旧值，可以在这一行加入断点，修改 data 调试来加深理解
            oldValue = data;
// cas 尝试修改 data 为 旧值 + 1，如果期间旧值被别的线程改了，返回 false
            if (unsafe.compareAndSwapInt(this, DATA_OFFSET, oldValue, oldValue +
                    1)) {
                return;
            }
        }
    }

    public void decrease() {
        int oldValue;
        while (true) {
            oldValue = data;
            if (unsafe.compareAndSwapInt(this, DATA_OFFSET, oldValue, oldValue -
                    1)) {
                return;
            }
        }
    }

    public int getData() {
        return data;
    }
}

