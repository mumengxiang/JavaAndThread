package Thread.part4;


import java.util.Optional;

public class ThreadSimpleApi {

    public static void main(String[] args) {
        Thread t=new Thread(()->{
            System.out.println("11111");
        },"t1");

        //得到名称
        Optional.of(t.getName()).ifPresent(System.out::println);
        //得到id
        Optional.of(t.getId()).ifPresent(System.out::println);
        //得到优先级(不准，多线程会混乱)
        Optional.of(t.getPriority()).ifPresent(System.out::println);

    }

}
