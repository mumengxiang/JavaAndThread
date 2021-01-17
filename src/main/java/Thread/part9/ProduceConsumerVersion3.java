package Thread.part9;

import java.util.stream.Stream;

/**
 * 第25讲 多生产 多消费的情形
 * 多个生产者和消费者因为notify方法是随机唤醒的，所有这里会发生所有的线程放弃cpu执行权的情况，会卡住。
 * 而这里使用notifyAll可以全部唤醒，就不会卡住了。所以wait()方法和notifyAll()一起使用
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
            //如果已经生产了数据，则需要wait();
            //注意这里wait()等待，如果被notifyAll唤醒，则会从Lock.wait();这行代码向下执行
            //这里的while是为了把flag拉回来重新判断，如果这里改成if就不会重新判断，当第一个线程执行
            //完之后进入wait()状态释放锁之后，第二个线程从Lock.wait()向下执行，会导致第一个线程生产的数据没有被消费而第二个数据已经生产出来了。
            while (flag){
                Lock.wait();
            }
            //如果有人把该线程唤醒则证明数据被消费完了，则需要生产数据
            i++;
            System.out.println("P->>>"+i);
            //通知消费者消费
            Lock.notifyAll();
            //改变标志
            flag = true;

        }
    }

    /**
     * 定义消费者
     */
    public void customer() throws InterruptedException {
        //加锁
        synchronized (Lock){
            //如果此时没有数据可供消费，则wait();
            while (!flag){
                Lock.wait();
            }
            //如果此时有人把该线程唤醒，则证明有数据可以消费，此时需要消费数据
            //消费
            System.out.println("C-->>>"+i);
            //然后发生通知
            Lock.notifyAll();
            //然后把需要生产标志变为flase
            flag = false;

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
                        Thread.sleep(10);
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
                        Thread.sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start()
        );
    }
}
