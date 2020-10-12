package Thread.part8;

/**
 * 死锁案例介绍
 */
public class DeadLockTest {

    public static void main(String[] args) {
        OtherServive otherServive = new OtherServive();
        DeadLock deadLock = new DeadLock(otherServive);
        otherServive.setDeadLock(deadLock);
        new Thread(){
            @Override
            public void run() {
                while (true){
                    otherServive.m2();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    deadLock.s1();
                }
            }
        }.start();


    }

}
