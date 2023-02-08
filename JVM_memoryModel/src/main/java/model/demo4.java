package model;

/**
 * @program: JVM
 * @description: happens-before
 * happens-before 规定了哪些写操作对其它线程的读操作可见，它是可见性与有序性的一套规则总结，
 * 抛开以下 happens-before 规则，JMM 并不能保证一个线程对共享变量的写，对于其它线程对该共享变
 * 量的读可见
 * @author: Mr.Carl
 **/
public class demo4 {
    static int x;
    static Object m = new Object();
    public static void main(String[] args) {
        //线程解锁 m 之前对变量的写，对于接下来对 m 加锁的其它线程对该变量的读可见
        new Thread(()->{
            synchronized(m) {
                x = 10;
            }
        },"t1").start();
        new Thread(()->{
            synchronized(m) {
                System.out.println(x);
            }
        },"t2").start();
        //线程对 volatile 变量的写，对接下来其它线程对该变量的读可见
        //volatile static int x;
        new Thread(()->{
            x = 10;
        },"t1").start();
        new Thread(()->{
            System.out.println(x);
        },"t2").start();

        //线程 start 前对变量的写，对该线程开始后对该变量的读可见

       // static int x;
        x = 10;
        new Thread(()->{
            System.out.println(x);
        },"t2").start();

        //线程结束前对变量的写，对其它线程得知它结束后的读可见（比如其它线程调用 t1.isAlive() 或
        //t1.join()等待它结束）

        //static int x;
//        Thread t1 = new Thread(()->{
//            x = 10;
//        },"t1");
//        t1.start();
//        t1.join();
//        System.out.println(x);


       // 线程 t1 打断 t2（interrupt）前对变量的写，对于其他线程得知 t2 被打断后对变量的读可见（通
        //过t2.interrupted 或 t2.isInterrupted）

//        static int x;
//        public static void main(String[] args) {
//            Thread t2 = new Thread(()->{
//                while(true) {
//                    if(Thread.currentThread().isInterrupted()) {
//                        System.out.println(x);
//                        break;
//                    }
//                }
//            },"t2");
//            t2.start();
//            new Thread(()->{
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                x = 10;
//                t2.interrupt();
//            },"t1").start();
//            while(!t2.isInterrupted()) {
//                Thread.yield();
//            }
//            System.out.println(x);
    }
}
