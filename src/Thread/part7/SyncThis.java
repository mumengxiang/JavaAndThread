package Thread.part7;

/**
 * this 锁
 */
public class SyncThis {

    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();

        //1.这种情况如果m1先抢到 则会是T1然后等待10sT2 ,此时锁就是this
        // 对于非static的synchronized方法，锁的就是对象本身，也就是this。
        //this是代表当前的对象，两个同步代码块指向的是同一个对象（拥有的是同一把锁），
        // 所以当一个线程进入到一个同步代码块，尽管是耗时操作，其余同步方法也是阻塞，在执行完毕后，在执行另一个方法。这种方法影响执行效率。
       new Thread("T1"){
           @Override
           public void run() {
               thisLock.m1();
           }
       }.start();

        new Thread("T2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();
    }


}


/**
 * 锁方法
 */
class ThisLock{

    public synchronized void m1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}