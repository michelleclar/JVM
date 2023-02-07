package jit;

/**
 * @program: JVM
 * @description: 逃逸分析
 * 0 - > c1 - > c1 - > c1 - > c2
 * @author: Mr.Carl
 **/
public class demo1 {
    //关闭逃逸分析 无法进入c2
    // -XX:+PrintCompilation -XX:-DoEscapeAnalysis
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                new Object();
            }
            long end = System.nanoTime();
            System.out.printf("%d\t%d\n",i,(end - start));
        }
    }
}
