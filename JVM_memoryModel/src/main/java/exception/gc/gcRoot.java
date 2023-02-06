package exception.gc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: JVM
 * @description: 查看gcRoot
 * 可达性分析算法
 * @author: Mr.Carl
 **/
public class gcRoot {
    //jps
    //jmap -dump:format=b,live,file=1.bin
    //文件格式,执行一次垃圾回收,文件名

    //-Xms10m -Xmx20m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=F:\hporf

    public static void main(String[] args) throws InterruptedException, IOException {
        List<Object> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        System.out.println(1);
        System.in.read();

        list1 = null;
        System.out.println(2);
        System.in.read();
        System.out.println("end...");
    }
}