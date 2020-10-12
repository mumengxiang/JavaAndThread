package Thread.part5;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread t=new Thread(){
            @Override
            public void run() {
                while (true) {
                    System.out.println(">>>" + this.isInterrupted());
                }
            }
        };
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
