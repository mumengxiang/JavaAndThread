package Java8Test;

import Java8Model.emplyee;
import Java8Model.emplyee.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 终止操作
 *
 */
public class StreamApi3 {
    List<emplyee> emplyeeList= Arrays.asList(
            new emplyee("111",1,111.11, emplyee.Status.busy),
            new emplyee("222",2,222.22,emplyee.Status.free),
            new emplyee("333",3,333.33, emplyee.Status.vacation),
            new emplyee("444",4,444.44,emplyee.Status.busy),
            new emplyee("444",4,444.44,emplyee.Status.free),
            new emplyee("555",4,444.44, emplyee.Status.vacation)
    );
    /**
     * 查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMacth-检查是否至少匹配一个元素
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-检查当前流中的任意元素
     * count-返回流中元素总个数
     * max-返回流中最大值
     * min-返回流中最小值
     */
    @Test
    public void test1(){
        //allmatch需要全部都匹配上 相当于&&
        boolean b1 = emplyeeList.stream().allMatch((e) -> e.getStatus().equals(emplyee.Status.free));
        System.out.println("****"+b1);
        //anymatch至少有一个匹配上 相当于 ||
        boolean b2 = emplyeeList.stream().anyMatch((e) -> e.getStatus().equals(emplyee.Status.free));
        System.out.println("****"+b2);
        //noneMacth
        boolean b3 = emplyeeList.stream().noneMatch((e) -> e.getStatus().equals(emplyee.Status.free));
        System.out.println("****"+b3);
        //findFirst
        Optional<emplyee> first = emplyeeList.stream().sorted((e1, e2) -> -Double.compare(e1.getSlary(), e2.getSlary())).findFirst();
        emplyee emplyee = first.get();
        System.out.println("**"+emplyee);
        // findAny
        emplyee e1 = emplyeeList.stream().filter((e) -> e.getStatus().equals(Status.free))
                .findAny().orElse(null);
        System.out.println("***"+e1);
        //count
        long count = emplyeeList.stream().count();
        System.out.println("**"+count);
        //max
        emplyee emplyee1 = emplyeeList.stream().max((e3, e2) -> Double.compare(e3.getSlary(), e2.getSlary())).get();
        System.out.println("**"+emplyee1);
        //min
        Double aDouble = emplyeeList.stream().map((e) -> e.getSlary()).min(Double::compareTo).get();
        System.out.println(aDouble);
    }

    /**
     * 归约 reduce 可以将流中的元素反复结合起来，得到一个新的值。
     */
    @Test
    public void test2(){
        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer result = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("***"+result);
        //求工资的总和
        Double aDouble = emplyeeList.stream().map(emplyee::getSlary)
                .reduce(Double::sum).get();
        System.out.println("***"+aDouble);
    }

    /**
     * 收集：
     * collect---将流转化为其他形式。接收一个Collector接口的实现，用于Stream中元素做汇总的方法
     */
    @Test
    public void test3(){
        List<emplyee> collect = emplyeeList.stream().filter((e) -> e.getSlary() > 200)
                                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        //放到特点的集合中
        //放到Hashset中
        HashSet<String> set = emplyeeList.stream().map(emplyee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        set.forEach(System.out::println);

        //平均值
        Double aDouble = emplyeeList.stream().collect(Collectors.averagingDouble(emplyee::getSlary));
        System.out.println("**平均值**"+aDouble);
        //总和
        Double bDouble = emplyeeList.stream().collect(Collectors.summingDouble(emplyee::getSlary));
        System.out.println("**总和**"+bDouble);

    }


    /**
     * 分组  ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆ ☆
     */
    @Test
    public  void test4(){
        Map<Status, List<emplyee>> listMap = emplyeeList.stream().collect(Collectors.groupingBy(emplyee::getStatus));
        System.out.println(listMap);
    }



}
