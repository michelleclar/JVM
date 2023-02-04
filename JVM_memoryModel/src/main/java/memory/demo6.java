package memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JVM
 * @description: jvisualvm查看对象个数
 * @author: Mr.Carl
 **/
public class demo6 {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
//            Student student = new Student();
        }
        Thread.sleep(1000000000L);
    }
}
class Student {
    private byte[] big = new byte[1024*1024];
}
