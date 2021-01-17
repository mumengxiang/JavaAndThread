package Thread.part6;

public class ThreadCloseGraceful2 {

    /**
     * 定义一个线程类
     */
    public static class Worder extends Thread{
        @Override
        public void run() {
            while (true){
               if(Thread.interrupted()){
                   //退出线程
                   break;
               }else {
                   //执行逻辑
                   System.out.println("111");
               }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worder worder=new Worder();
        worder.start();
        Thread.sleep(10000);

        //打断
        worder.interrupt();
    }
}
