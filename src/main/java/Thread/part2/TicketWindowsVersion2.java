package Thread.part2;

/**
 * 要求：假设有银行有4个窗口，用多线程实现4个窗口按照1到50的顺序叫1~50号的号码，
 *  4个窗口叫的50个号没有遗漏。
 *  使用Runnable将线程的逻辑执行单元从控制中抽离出来
 *  版本二
 */
public class TicketWindowsVersion2 implements Runnable{

    private static final int Max=50;
    private int index=1;
    @Override
    public void run() {
        while (index<=Max){
            System.out.println(Thread.currentThread()+"请"+(index++)+"号客户办理业务。");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
