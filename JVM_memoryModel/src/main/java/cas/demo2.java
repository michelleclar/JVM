package cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: JVM
 * @description: AtomicInteger
 * @author: Mr.Carl
 **/
public class demo2 {

    private static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                i.getAndIncrement(); // 获取并且自增 i++
// i.incrementAndGet(); // 自增并且获取 ++i
            }
        });
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                i.getAndDecrement(); // 获取并且自减 i--
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }


}
