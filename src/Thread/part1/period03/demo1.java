package Thread.part1.period03;

public class demo1 {
    public static void main(String[] args) {
        /**
         * 方法一，以thread启动线程
         */
        Thread t1=new Thread("customer"){
            @Override
            public void run() {
                saybay();
            }
        };
        t1.start();
        sayhello();

    }


    public static void sayhello(){
        for (int i=0;i<10000;i++){
            System.out.println("第"+i+"个sayhello()");
        }



    }
    public static  void saybay(){
        for (int i=0;i<10000;i++){
            System.out.println("第"+i+"个saybay()");
        }
    }
}
