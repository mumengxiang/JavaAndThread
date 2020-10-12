package Thread.part5;

import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) throws Exception{
        //开启一个线程
        Thread t=new Thread(()->{
            IntStream.range(0,1000).forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
        });

        //开启第二个线程
        Thread t1=new Thread(()->{
            IntStream.range(0,1000).forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
        });
        t.start();
        t1.start();
        //如果没有join，两者会交替，如果有join则会执行完t线程再执行主线程
        //注意 join的坐标对象是主线程，所有t1和t有交互
        t.join();
        //  t.join(100,120);毫秒  纳秒
        t1.join();
        //主线程中也使用此方法
        IntStream.range(0,1000).forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));

        //【注】当遇到JettyHttpServer.start()类的之后可能会一会死掉，可以用Thread.currentThread().join();来使线程处于开启状态
//        Thread.currentThread().join();

    }
}
