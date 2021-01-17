package Thread.part2;


/**
 * 要求：假设有银行有4个窗口，用多线程实现4个窗口按照1到50的顺序叫1~50号的号码，
 *  4个窗口叫的50个号没有遗漏。
 *  版本一
 */
public class Bank {

    public static void main(String[] args) {
        TicketWindows ticketWindows1=new TicketWindows("一号柜台");
        ticketWindows1.start();

        TicketWindows ticketWindows2=new TicketWindows("二号柜台");
        ticketWindows2.start();

        TicketWindows ticketWindows3=new TicketWindows("三号柜台");
        ticketWindows3.start();
    }

}
