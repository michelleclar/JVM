package avo;

/**
 * @program: JVM
 * @description: 原子性
 * @author: Mr.Carl
 **/
public class demo1 {
    static int i = 0;

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                for (int j = 0; j < 50000; j++) {
                    i++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                for (int j = 0; j < 50000; j++) {
                    i--;
                }
            }
        });
        //启动线程
        t1.start();
        t2.start();
        //等待线程结束
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
