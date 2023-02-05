package exception;

/**
 * @program: JVM
 * @description: finlly中return会吞异常
 * @author: Mr.Carl
 **/
public class demo2 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    public static int test() {
        try {
            int i = 1/0;
            return 10;
        } finally {
            return 20;
        }
    }
}
