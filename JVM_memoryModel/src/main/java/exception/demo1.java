package exception;

/**
 * @program: JVM
 * @description: finally的执行顺序
 * @author: Mr.Carl
 **/
public class demo1 {
    public static void main(String[] args) {
        int i = 0;
        try {
            i = 10;
        } catch (Exception e) {
            i = 20;
        } finally {
            i = 30;
        }
    }
}
