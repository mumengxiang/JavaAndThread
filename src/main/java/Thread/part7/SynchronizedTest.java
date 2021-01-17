package Thread.part7;

public class SynchronizedTest {

    //设定锁
    private static  final Object object = new Object();

    public static void main(String[] args) {
        Runnable runnable = ()->{
            synchronized (object){
                try {
                    Thread.sleep(200_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }

}
