package Thread.part8;

public class DeadLock {

    private OtherServive otherServive;

    //定义一个锁
    private final Object lock = new Object();
    public DeadLock(OtherServive otherServive){
        this.otherServive = otherServive;
    }

    public void s1(){
        synchronized (lock){
            System.out.println("s1==========================");
            otherServive.m1();
        }
    }

    public void s2(){
        synchronized (lock){
            System.out.println("s2==========================");
        }
    }
}
