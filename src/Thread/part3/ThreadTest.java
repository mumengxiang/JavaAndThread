package Thread.part3;

public class ThreadTest {

    public static void main(String[] args) {
//        //实例一
//        System.out.println("**实例一**");
//        Thread t=new Thread();
//        t.start();
//        System.out.println(t.getName());
//
//        //实例二
//        System.out.println("**实例二**");
//        Thread t1=new Thread(){
//            @Override
//            public void run() {
//                System.out.println("--------------------------");
//            }
//        };
//        t1.start();
//
//        //实例三
//        System.out.println("**实例三**");
//        Thread t2=new Thread(()->{
//            System.out.println("***********************");
//        },"threadName");
//        t2.start();
//
//        //实例四
//        System.out.println("**实例四**");
//        System.out.println(Thread.currentThread().getThreadGroup().getName());
//        Thread t3=new Thread();
//        t3.start();
//        System.out.println(t3.getThreadGroup().getName());

        //实例五
        Thread t4=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t4.start();
        ThreadGroup threadGroup=Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (Thread t:threads) {
            System.out.println(t);
        }

    }


}
