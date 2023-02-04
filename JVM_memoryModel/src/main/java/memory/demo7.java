package memory;

import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.ClassWriter;

/**
 * @program: JVM
 * @description: 元空间内存溢出
 * 元空间和操作系统物理内存有关
 * TODO:类加载器,字节码文件,常量池
 * 串池在堆中
 * @author: Mr.Carl
 **/
public class demo7 extends ClassLoader{
    //虚拟机参数-XX:MaxMetaspaceSize=8m
    public static void main(String[] args) {
        int j = 0;
        try {
            demo7 test = new demo7();
            for (int i = 0; i < 10000; i++, j++) {
                // ClassWriter 作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                // 版本号， public， 类名, 包名, 父类， 接口
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                // 返回 byte[]
                byte[] code = cw.toByteArray();
                // 执行了类的加载
                test.defineClass("Class" + i, code, 0, code.length); // Class 对象
            }
        } finally {
            System.out.println(j);
        }
    }
}