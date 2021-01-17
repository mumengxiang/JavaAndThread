package Thread.part9.demo;

/**
 * 厨房
 * 负责做食物 鸡
 *
 */
class Kitchen extends Thread{
    Container container;

    public Kitchen(Container container) {
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("厨房生产了一只鸡："+i);
                container.pop(new Chicken(i+""));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}