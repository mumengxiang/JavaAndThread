package Thread.part8;

public class OtherServive {

    private DeadLock deadLock;

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
    //定义一个锁
    private final Object lock = new Object();

    public void m1() {
        synchronized (lock){
            System.out.println("m1====================");
        }
    }

    public void m2() {
        synchronized (lock){
            System.out.println("m2====================");
            deadLock.s2();
        }
    }
}
