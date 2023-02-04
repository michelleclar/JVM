package memory;

/**
 * @program: JVM
 * @description: 栈溢出测试
 * @author: Mr.Carl
 **/
public class demo2 {
    //虚拟机参数-Xss256k
    static int count = 0;

    public static void main(String[] args) {
        try {
            method();
        } catch (Throwable e) {

            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method() {
        count++;
        method();
    }
}
