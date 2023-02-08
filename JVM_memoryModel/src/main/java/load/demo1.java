package load;

import java.io.IOException;

/**
 * @program: JVM
 * @description: 连接-解析阶段
 * @author: Mr.Carl
 **/
public class demo1 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        ClassLoader classloader = Load2.class.getClassLoader();
//        Class<?> c = classloader.loadClass("load.C");
        new C();
        System.in.read();
    }
}

class C {
    D d = new D();
}

class D {

}
