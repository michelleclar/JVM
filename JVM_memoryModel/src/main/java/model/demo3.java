package model;

/**
 * @program: JVM
 * @description: 有序性
 * @author: Mr.Carl
 **/
public class demo3 {
    int num = 0;
    boolean ready = false;
    // 线程1 执行此方法
    public void actor1(I_Result r) {
        if(ready) {
            r.r1 = num + num;
        } else {
            r.r1 = 1;
        }
    }
    // 线程2 执行此方法
    public void actor2(I_Result r) {
        num = 2;
        ready = true;
    }

}

class I_Result{
    int r1 = 0;
}
