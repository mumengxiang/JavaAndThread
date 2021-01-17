package Thread.part10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BooleanLock implements Lock {

    /**
     * 判断线程是否被锁住
     */
    private boolean intValue;

    //定义当前的锁,这里是为了只有开启这个锁的线程才能释放锁
    private Thread currentThread;

    private Collection<Thread> blockThreadCollection = new ArrayList<>();

    /**
     * 构造函数初始化intValue的值
     * true:表示上已经上锁了
     * false:表示未上锁
     */
    public BooleanLock(){
        this.intValue = false;
    }


    /**
     * 定义锁方法
     * synchronized得到的是BooleanLock这个实例
     * @throws InterruptedException
     */
    @Override
    public synchronized void lock() throws InterruptedException {
        //当已经上锁之后
        while (intValue){
            //把当前线程放入到线程队列中，并使线程wait()
            blockThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        //如果没有上锁则需要把线程上锁
        this.intValue = true;
        this.currentThread = Thread.currentThread();
        //并同时在线程阻塞队列中删除该线程
        blockThreadCollection.remove(Thread.currentThread());
    }

    /**
     * 定义锁方法（时间）
     *
     * @param mills
     * @throws InterruptedException
     * @throws TimeOutException
     */
    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        //如果超时时间小于0，则直接调用lock方法
        if(mills <= 0){
            lock();
        }
        //得到超时时长标记
        long hasRemaining = mills;
        //得到结束时间
        long endTime = System.currentTimeMillis() + mills;
        //当锁已经锁定即被抢了时
        while (intValue) {
            //如果前时间和endTime的差距大于0时，则表示该线程超时了
            if(hasRemaining >= 0){
                throw new TimeOutException("Time Out");
            }
            //wait()这么多mills，然后等待唤醒
            this.wait(mills);
            //把当前线程放入到线程队列中
            blockThreadCollection.add(Thread.currentThread());
            //被唤醒之后，查看当前时间和endTime的差距
            hasRemaining = System.currentTimeMillis() - endTime;
            System.out.println(hasRemaining);
        }
        //如果抢到了锁
        intValue = true;
        //并把当前线程赋值给线程标记
        this.currentThread = Thread.currentThread();
    }

    /**
     * 定义释放锁的方法
     * synchronized得到的是BooleanLock这个实例
     */
    @Override
    public synchronized void unlock() {
        //解锁的时候只有开启这个锁的线程才能释放锁
        if(Thread.currentThread() == currentThread){
            //释放锁需要把intValue的值置为false,并同时唤醒线程中的线程
            this.intValue = false;
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            this.notifyAll();
        }

    }

    /**
     * 得到阻塞的线程集合
     * 此处没有加synchronized会导致blockThreadCollection的数据不安全，即当在外部
     * 调用getBlockThread这个方法时可能导致blockThreadCollection里面的值发生改变，所有这里需要把blockThreadCollection设置为不可修改的
     * @return
     */
    @Override
    public Collection<Thread> getBlockThread() {
        //把blockThreadCollection设置为不可修改的
        return Collections.unmodifiableCollection(blockThreadCollection);
    }

    /**
     * 得到阻塞的大小
     *
     * @return
     */
    @Override
    public int getBlockSize() {
        return blockThreadCollection.size();
    }
}
