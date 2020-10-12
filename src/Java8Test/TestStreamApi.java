package Java8Test;

import Java8Model.emplyee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamApi {
    List<emplyee> emplyeeList= Arrays.asList(
            new emplyee("111",1,111.11, emplyee.Status.busy),
            new emplyee("222",2,222.22,emplyee.Status.free),
            new emplyee("333",3,333.33, emplyee.Status.vacation),
            new emplyee("444",4,444.44,emplyee.Status.busy),
            new emplyee("444",4,444.44,emplyee.Status.free),
            new emplyee("555",4,444.44, emplyee.Status.vacation)
    );

    /**
     * 1.给定一个数字列表，如何放一个由每个数的平方构成的列表呢？
     * 给定【1,2,3,4,5】,应该返回【1,4,9,16,25】
     */
    @Test
    public void test1(){
        List<Integer> resultList= Arrays.asList(1,2,3,4,5);
        resultList.stream().map((x)->x*x).forEach(System.out::println);
    }
    /**
     * 2.怎样用map和reduce方法数一数流中有多少个enplyee.
     */
    @Test
    public void test2(){
        long count = emplyeeList.stream().count();
        System.out.println("***"+count);
        Optional<Integer> count1 = emplyeeList.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println("***"+count1.get());
    }

}
