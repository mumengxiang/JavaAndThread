package Thread.part6.ThreadCloseForce;

/**
 * 原理：使用如果一个线程死亡该线程的守护线程也会死亡的原理
 */
public class ThreadService {


    private Thread executeThread;

    private Boolean finished = false;

    /**
     * 执行线程
     * @param task 传过来的任务
     */
    public void execute(Runnable task){
        //包裹传过来的任务的线程 如果它死亡那么传过来的任务也会死亡
        executeThread=new Thread(){
            @Override
            public void run() {
                //把传过来的任务变成守护线程
                Thread runner=new Thread(task);
                //设置为守护线程
                runner.setDaemon(true);
                //启动线程
                runner.start();
                //为了防止线程启动就结束，不执行任务线程这里要join
                try {
                    runner.join();
                    //设置线程完成标志
                    finished = true;
                } catch (InterruptedException e) {
                    //这里表示打断了，退出线程
                }
            }
        };
        //启动线程
        executeThread.start();
    }

    public void shotDown(long mills){
        long currentTime = System.currentTimeMillis();
        //如果线程没完成的话
        while(!finished){
            if(System.currentTimeMillis()-currentTime > mills){
                System.out.println("任务超时，需要结束他！");
                //打断
                executeThread.interrupt();
                break;
            }

            //这里在while循环里，此时表示线程没有执行结束同时也没超时，这里短暂的休眠一下，这里休眠的
            //目的是让那些执行时间小于mills的任务可以结束
            try {
                //☆☆☆☆☆☆☆这里在循环里
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断！！！");
                break;
            }
        }
        //这里吧变量值为false
        finished = false;
    }


}
