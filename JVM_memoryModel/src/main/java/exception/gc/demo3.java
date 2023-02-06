package exception.gc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: JVM
 * @description: 弱引用
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * 在垃圾回收时就会进行处理
 * @author: Mr.Carl
 **/
public class demo3 {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        //  list --> WeakReference --> byte[]
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w : list) {
                System.out.print(w.get()+" ");
            }
            System.out.println();

        }
        System.out.println("循环结束：" + list.size());
    }
}

