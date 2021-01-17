package Thread.part9.demo;

/**
 * 食客
 * 负责吃鸡
 */
class Customor extends Thread{
    Container container;

    public Customor(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                System.out.println("食客消费了一只鸡："+container.eat().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}