package Thread.part9;

public class ProduceConsumerVersion1 {

    static int i =1;
    static final private Object Lock = new Object();

    private static void produce(){
        synchronized (Lock){
            System.out.println("P-->"+(i++));
        }
    }
    private static void coustomer(){
        synchronized (Lock){
            System.out.println("C-->"+i);
        }
    }

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (true){
                    produce();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    coustomer();
                }
            }
        }.start();
    }
}
