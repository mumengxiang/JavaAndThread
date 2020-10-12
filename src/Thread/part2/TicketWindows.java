package Thread.part2;

/**
 * 要求：假设有银行有4个窗口，用多线程实现4个窗口按照1到50的顺序叫1~50号的号码，
 *  4个窗口叫的50个号没有遗漏。
 *  版本一
 */
public class TicketWindows extends  Thread{
    //名称
    private String name;
    public TicketWindows(String name) {
        this.name = name;
    }
    private static final int Max=50;
    private static int index=1;
    @Override
    public void run() {
        while (index<=Max){
            System.out.println(name+"柜台请"+index+"号客户办理业务。");
            index=index+1;
        }
    }
}


