package Java8Test;

import Java8Model.emplyee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 步骤
 * 1.创建Stream
 * 
 * 2.中间操作
 * 
 * 3.终止操作
 */
public class StreamApi {
    public static void main(String[] args) {
        //创建Stream
        //1.可以通过Collection系列集合提供的Stream()或parallelSteam()方法创建
        List<String> list=new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays的Stream()方法获得流
        emplyee []e=new emplyee[10];
        Stream<emplyee> emplyeeStream = Arrays.stream(e);

        //3 通过Steam.of()获得流
        Stream<String> stringStream = Stream.of("11", "22");

        //4.获得无限流
        //迭代
        Stream<Integer> integerStream = Stream.iterate(0, x -> x + 2);
//        integerStream.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random()).forEach(System.out::println);
    }
}
