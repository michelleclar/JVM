package exception;

/**
 * @program: JVM
 * @description: finally中对return的影响
 * @author: Mr.Carl
 **/
public class demo3 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    public static int test() {
        int i = 10;
        try {
            return i;
        } finally {
            i = 20;
        }
    }
}
