package Thread.part7;

/**
 * 采用策略模式
 * 要求：假设有银行有4个窗口，用多线程实现4个窗口按照1到50的顺序叫1~50号的号码，
 *  4个窗口叫的50个号没有遗漏。
 *  使用Runnable将线程的逻辑执行单元从控制中抽离出来
 *  版本二
 */
public class Bank2 {

    public static void main(String[] args) {
        TicketWindowsVersion2 ticketWindowsVersion2=new TicketWindowsVersion2();
        Thread thread1=new Thread(ticketWindowsVersion2,"一号柜台");
        Thread thread2=new Thread(ticketWindowsVersion2,"二号柜台");
        Thread thread3=new Thread(ticketWindowsVersion2,"三号柜台");
        //启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
