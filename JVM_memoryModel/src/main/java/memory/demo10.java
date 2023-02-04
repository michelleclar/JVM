package memory;

/**
 * @program: JVM
 * @description: StringTable 垃圾回收
 * @author: Mr.Carl
 **/
public class demo10 {
    //-Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
    //虚拟机堆内存最大值 字符串池的统计信息 垃圾回收的详细信息(次数,时间)
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        try {
            for (int j = 0; j < 100000; j++) { // j=100, j=10000
                String.valueOf(j).intern();
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }

    }
}


