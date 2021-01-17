package Thread.part9;

/**
 * 第24讲
 */
public class ProduceConsumerVersion2 {

    //定义商品
    private int i = 0;
    //定义锁
    final private Object Lock = new Object();
    //定义标志(是否已生产)
    private volatile  Boolean flag = false;

    //定义生产者
    public void produce() throws InterruptedException {
        synchronized (Lock){
            //如果已经生产了
            if(flag){
                //等待
                Lock.wait();
            }else {
                //否则需要生产
                i++;
                System.out.println("P->>>"+i);
                //通知消费者消费
                Lock.notify();
                //改变标志
                flag = true;
            }
        }
    }

    /**
     * 定义消费者
     */
    public void customer() throws InterruptedException {
        //加锁
        synchronized (Lock){
            //如果已经生产了
            if(flag){
                //消费
                System.out.println("C-->>>"+i);
                //然后发生通知
                Lock.notify();
                //然后把需要生产标志变为flase
                flag = false;
            }else {
                //如果没有生产 则等待
                Lock.wait();
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion2 produceConsumerVersion2 = new ProduceConsumerVersion2();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        produceConsumerVersion2.produce();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        produceConsumerVersion2.customer();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
