package Thread.part10;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 第29讲 如何实现一个显式锁Lock精讲
 * 需求：实现一个显式锁Lock精讲
 */
public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        //定义显示锁
        final BooleanLock booleanLock = new BooleanLock();
        //定义4个线程并开启，这里使用lambda表达式形式
        Stream.of("T1", "T2", "T3", "T4")
                .forEach(name ->
                        new Thread(() -> {
                            //定义线程需要做的事
                            try {
                                //首先线程上锁
                                booleanLock.lock();
                                //定义log
                                Optional.of(Thread.currentThread().getName()+"已经上锁").ifPresent(System.out::println);
                                //然后开始工作
                                work();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            finally {
                                //最后释放锁
                                booleanLock.unlock();
                            }
                        }, name).start()
                );

        Thread.sleep(100);
        booleanLock.unlock();
    }


    /**
     * 定义线程实现的方法
     * @throws InterruptedException
     */
    private static void work() throws InterruptedException{
        //定义log
        Optional.of(Thread.currentThread().getName()+"正在工作").ifPresent(System.out::println);
        //这里工作是睡眠10s
        Thread.sleep(10_000);

    }
}
