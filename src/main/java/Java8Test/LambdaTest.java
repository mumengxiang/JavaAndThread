package Java8Test;

import Java8Model.emplyee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest {

    public static void main(String[] args) {
        List<emplyee> list= Arrays.asList(
                new emplyee("111",1,111.11),
                new emplyee("222",2,222.22),
                new emplyee("333",3,333.33),
                new emplyee("444",4,444.44)
        );
//        List<emplyee> resultList=filterList(list,(e) -> e.getSlary() <200);
//        resultList.forEach(System.out::println);
        list.stream().filter((e)->e.getSlary()>200)
                .map(emplyee::getName)
                .forEach(System.out::println);
    }

    private static List<emplyee> filterList(List<emplyee> list, Predicate<emplyee> condition) {
        List<emplyee> resultList=new ArrayList<>();
        try {
            for (emplyee e:list) {
                if(condition.test(e)){
                    resultList.add(e);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

}
