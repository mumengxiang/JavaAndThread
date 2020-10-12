package Thread.part6.ThreadCloseForce;

/**
 * 强制关闭
 */
public class ThreadCloseForce {
    public static void main(String[] args) {
        //设置一个线程
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();

        service.execute(()->{
            //情形1.这里模拟一个很长时间的操作
            while (true){

            }

            //情形2：如果任务5s就可以搞定，这里也不需要傻傻的等到10s
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });

        //设置超时时间为10s
        service.shotDown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
