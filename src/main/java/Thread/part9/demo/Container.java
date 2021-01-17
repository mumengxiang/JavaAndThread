package Thread.part9.demo;

class Container {
    /**
     * 鸡容器 最多放十只鸡
     */
    private Chicken [] chickens = new Chicken[10];
    /**
     * 鸡的数量
     */
    int size = 0;

    /**
     * 食客吃掉一只鸡
     */
    public synchronized Chicken eat() throws InterruptedException {
        //  等待生产者生产，消费者等待
        //如果鸡没有吃完则消费者可以吃掉一只鸡
        if(size == 0){
            this.wait();
        }
        size--;
        Chicken chicken =  chickens[size];
        //唤醒所有等待线程
        this.notifyAll();
        return chicken;
    }

    /**
     * 厨房做出一只鸡
     */
    public synchronized void pop(Chicken chicken) throws InterruptedException {
        //  如果记得数量等于器皿的存放数量
        //  通知消费者消费 生产者等待
        if(size == chickens.length){
            this.wait();
        }
        //不等于器皿数量则添加一只鸡到指定位置
        chickens[size] = chicken;
        size++;
        //唤醒所有等待线程
        this.notifyAll();
    }
}