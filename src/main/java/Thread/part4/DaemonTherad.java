package Thread.part4;

public class DaemonTherad {

    public static void main(String[] args) throws InterruptedException {

        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //设置为守护线程则父线程退出后该守护线程也会退掉
        t.setDaemon(true);
        t.start();
        Thread.sleep(1000);
        System.out.println("************************");
        System.out.println(Thread.currentThread().getName());
    }

}
