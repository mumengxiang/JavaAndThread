package Thread.part9.demo;

public class ThreadCommication {

    public static void main(String[] args) {
        //容器
        Container container = new Container();
        //厨房 并将容器 丢给厨房
        Kitchen kitchen = new Kitchen(container);
        //食客 和厨房共享一个容器
        Customor customor = new Customor(container);
        //启动线程
        kitchen.start();
        customor.start();

    }
}