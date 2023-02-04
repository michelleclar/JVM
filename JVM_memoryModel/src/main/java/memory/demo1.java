package memory;

/**
 * @program: JVM
 * @description: stringBuild的测试
 * @author: Mr.Carl
 **/
public class demo1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append(4).append(5).append(6);
        new Thread(() -> {
            m2(sb);
        }).start();
        System.out.println(sb);
    }

    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(2).append(3);
        System.out.println(sb);
    }

    private static void m2(StringBuffer sb) {
        sb.append(1).append(2).append(3);
        System.out.println(sb);
    }

    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(2).append(3);
        return sb;
    }


}
