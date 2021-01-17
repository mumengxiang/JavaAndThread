package Thread.part6;

/**
 * 使用interrupt关闭线程
 */
public class ThreadCloseGraceful {

    /**
     * 定义一个线程类
     */
    public static class Worder extends Thread{
        public  boolean flag=true;
        @Override
        public void run() {
            while (flag){
                System.out.println("111");
            }
        }
        //定义开关
        public void shotDown(){
            flag=false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worder worder=new Worder();
        worder.start();
        Thread.sleep(10000);

        //启动开关关闭线程
        worder.shotDown();
    }
}
