package Thread.part9;

import java.util.stream.Stream;

/**
 * 第25讲 多生产 多消费的情形
 * 多个生产者和消费者因为notify方法是随机唤醒的，所有这里会发生所有的线程放弃cpu执行权的情况，会卡住。
 */
public class ProduceConsumerVersion3 {

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
        ProduceConsumerVersion3 produceConsumerVersion2 = new ProduceConsumerVersion3();

        //多个消费者 lamdba表达式
        Stream.of("P1","P2").forEach( n ->
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
        }.start()
        );

        //多个S生产者 lamdba表达式
        Stream.of("C1","C2").forEach( n ->
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
        }.start()
        );
    }
}
