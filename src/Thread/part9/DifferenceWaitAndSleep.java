package Thread.part9;

public class DifferenceWaitAndSleep {
    //定义monitor
    final private static Object Lock = new Object();

    public static void main(String[] args) {
//        m1();
        m2();
    }

    //使用sleep方式
    public static void m1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m2(){
        try {
            //这里还需要使用synchronized
            synchronized (Lock) {
                Lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
