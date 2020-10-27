package Thread.part10;

import java.util.Collection;

/**
 * 定义显示锁得我接口
 */
public interface Lock {

    /**
     * 定义超时
     */
    class TimeOutException extends Exception{
        public TimeOutException(String message){
            super(message);
        }
    }

    /**
     * 定义锁方法
     * @throws InterruptedException
     */
    void lock() throws InterruptedException;

    /**
     * 定义锁方法（时间）
     * @param mills
     * @throws InterruptedException
     * @throws TimeOutException
     */
    void lock(long mills) throws InterruptedException,TimeOutException;

    /**
     *定义释放锁的方法
     */
    void unlock();

    /**
     * 得到阻塞的线程集合
     * @return
     */
    Collection<Thread> getBlockThread();

    /**
     * 得到阻塞的大小
     * @return
     */
    int getBlockSize();
}
