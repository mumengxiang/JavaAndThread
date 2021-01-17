package Thread.part9;

import java.util.*;

/**
 * 第28讲 线程生产者消费者的总结案例
 * 需求：需求是一次开启10个线程，但是只有5个线程可以同时运行，并且只有在前一个线程执行完毕之后才会执行
 * 下一个线程
 */
public class CapureService {

    //定义monitoir
    final static private LinkedList<Control> CONTROLS = new LinkedList<>();

    public static void main(String[] args) {
        //定义线程的集合
        List<Thread> worker = new ArrayList<>();
        //定义十个线程
        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10").stream()
                //命名线程
                .map(CapureService::createCapureServiceThread)
                .forEach(t -> {
                    //启动线程
                    t.start();
                    //把线程加入到线程集合中
                    worker.add(t);
                });
        //然后让主线程等待线程集合按照串行执行完
        worker.stream().forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("All capture finished end")
                .ifPresent(System.out::println);
    }

    /**
     * 定义线程实现类
     */
    public static Thread createCapureServiceThread(String name) {
        return new Thread(() -> {
            //开始接收数据
            Optional.of("The worker[" + Thread.currentThread().getName() + "] begin capture data")
                    .ifPresent(System.out::println);
            //定义同步锁
            synchronized (CONTROLS) {
                while (CONTROLS.size() >= 5) {
                    //当CONTROLS里的容量大于等于5时则休眠
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //第一步
                //执行线程的主体操作即线程容量小于5时要做的工作
                //首先需要在CONTROLS里的最后加1
                //放在这里是为了防止在线程被唤醒导致数据的不同步，这里吧把他加入到synchronized里面进行数据保护
                CONTROLS.addLast(new Control());
            }
            Optional.of("The worker[" + Thread.currentThread().getName() + "] is working")
                    .ifPresent(System.out::println);
            //第二步
            //然后做线程的逻辑操作，这里是休眠
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //第三步
            //
            //当线程的逻辑操作执行完之后，这里需要唤醒其他线程,并同时在CONTROLS集合中减少一个线程
            synchronized (CONTROLS) {
                Optional.of("The worker[" + Thread.currentThread().getName() + "] is END working")
                        .ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }

        }, name);
    }

    //定义一个保持线程的类
    private static class Control {

    }
}


