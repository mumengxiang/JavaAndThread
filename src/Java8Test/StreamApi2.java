package Java8Test;

import Java8Model.emplyee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 中间操作1
 */
public class StreamApi2 {
    List<emplyee> emplyeeList= Arrays.asList(
            new emplyee("111",1,111.11),
            new emplyee("222",2,222.22),
            new emplyee("333",3,333.33),
            new emplyee("444",4,444.44),
            new emplyee("444",4,444.44),
            new emplyee("555",4,444.44)
    );
    /**
     * filter:接收Lambda，从流中排除某些元素
     * limit:截断流 使其元素不超过给定数量
     * skip(n):跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n)互补
     * distinct:筛选，通过流所生成元素的hashcode()和equals()去除重复元素。
     */
    //filter和limit
    @Test
    public void test(){
        //filter：中间操作  forEach：终止操作
        emplyeeList.stream().filter((e)->e.getAge()>1).limit(2).forEach(System.out::println);
    }
    @Test
    //skip(n)
    public void test1(){
        emplyeeList.stream().skip(1).forEach(System.out::println);
    }
    @Test
    public void test2(){
        emplyeeList.stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射
     * map: 接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每一个元素上，并被其映射为一个新的元素
     * flatMap:接收一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连接成一个新的流
     */
    @Test
    public void test3(){
        //map
        List<String> list=Arrays.asList("aaa","bbb");
        list.stream().map((e)->e.toUpperCase()).forEach(System.out::println);
        emplyeeList.stream().map((e)->e.getName()).forEach(System.out::println);
        //flatMap
        list.stream().flatMap(StreamApi2::getCharacter).forEach(System.out::println);
    }

    public static Stream<Character> getCharacter(String str){
        List<Character> resultList=new ArrayList<>();
        for (Character ch:str.toCharArray()) {
            resultList.add(ch);
        }
        return resultList.stream();
    }


    /**
     * 排序
     * sorted() -自然排序(Comparable)
     * sorted(Comparator com) -定制排序
     */
    @Test
    public void test4(){
        //map
        List<String> list=Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream().sorted().forEach(System.out::println);
        emplyeeList.stream()
                    .sorted((e1,e2)->{
                        if(e1.getAge().equals(e2.getAge())){
                            return e1.getName().compareTo(e2.getName());
                        }else {
                            return e1.getAge().compareTo(e2.getAge());
                        }
                    }).forEach(System.out::println);
    }



}
