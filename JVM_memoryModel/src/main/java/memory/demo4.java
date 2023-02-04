package memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JVM
 * @description: 堆内存溢出
 * @author: Mr.Carl
 **/
public class demo4 {
    //虚拟机命令-Xmx8m
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(new String(a));
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
