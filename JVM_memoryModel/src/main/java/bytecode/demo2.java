package bytecode;

/**
 * @program: JVM
 * @description: synchronized
 * 字节码角度
 * @author: Mr.Carl
 **/
public class demo2 {
    public static void main(String[] args) {
        Object obj = new Object();
        synchronized (obj){
            System.out.println("syn");
        }
    }
}
