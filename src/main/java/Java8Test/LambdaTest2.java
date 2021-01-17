package Java8Test;

import Java8Model.MF;
import Java8Model.MT;
import Java8Model.emplyee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest2 {

    public static void main(String[] args) {
//        Runnable t=()-> System.out.println("111");
//        t.run();

        //x为lambda的参数  System.out.println("***"+x)为lambda的实现方法
//        Consumer<String> t=(x)-> System.out.println("***"+x);
//        t.accept("33333");

//        Comparator<Integer> comparator = (x, y) -> {
//            return Integer.compare(x, y);
//        };

//        List<emplyee> list= Arrays.asList(
//                new emplyee("111",1,111.11),
//                new emplyee("222",2,222.22),
//                new emplyee("333",3,333.33),
//                new emplyee("444",4,444.44)
//        );
//        Collections.sort(list,(e1,e2)->{
//            if(e1.getAge()==e2.getAge()){
//                return e1.getName().compareTo(e2.getName());
//            }else {
//                return -Integer.compare(e1.getAge(),e2.getAge());
//            }
//        });
//        list.stream().forEach(System.out::println);

//            String t="WsEaSS";
//        String tt=getMax(t,(x)->{
//            return x.toUpperCase();
//        });
//        System.out.println(tt);
//
//        String SS=getMax(t,(x)->{
//            return x.substring(2,4);
//        });
//        System.out.println(SS);

    }

    public static String getMax(String val,MF mf){
        return mf.getValue(val);
    }


}
