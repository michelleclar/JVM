package jit;

/**
 * @program: JVM
 * @description: 方法内联
 * @author: Mr.Carl
 **/
public class demo2 {
    // 打印内联信息 禁用某个方法内联
    // -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining -XX:CompileCommand=dontinline,*demo2.square
    // -XX:+PrintCompilation

    public static void main(String[] args) {

        int x = 0;
        for (int i = 0; i < 500; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                x = square(9);

            }
            long end = System.nanoTime();
            System.out.printf("%d\t%d\t%d\n",i,x,(end - start));
        }
    }

    private static int square(final int i) {
        return i * i;
    }
}

