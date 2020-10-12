package Java8Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 4大核心函数式接口
 * consumer<T>:消费型接口
 *      void accept（T t)
 * supplier<T> 供给型接口
 *      T get()
 * Function<T,R>:函数型接口
 *     R apply(T t)
 * Predicate(T):断言型接口
 *     Boolean test(T t)
 */
public class 核心函数式接口 {
    public static void main(String[] args) {
        //消费型接口
        happy(10000.0,(x)->{
            System.out.println(x);
        });
        //供给型接口
        List<Integer> integers = makeList(20, () -> {
            return 1;
        });
        integers.forEach(System.out::print);
        System.out.println("");
        //函数型接口
        String temp="wert";
        Integer length = getStringLength(temp, (x) -> {
            return  x.length();
        });
        System.out.println(length);
        //断言型接口
        Boolean b=getContains(temp,(x)->{
            if(x.contains("w")){
                return true;
            }else {
                return false;
            }
        });
        System.out.println(b);
    }

    public static void happy(Double d, Consumer<Double> p){
        p.accept(d);
    }

    public static List<Integer> makeList(Integer num, Supplier<Integer> sup){
        List<Integer> resultList=new ArrayList<>();
        for (int i=0;i<num;i++){
            resultList.add(sup.get());
        }
        return resultList;
    }

    public static Integer getStringLength(String val, Function<String,Integer>fun){
        return fun.apply(val);
    }

    public static Boolean getContains(String val, Predicate<String>pre){
        return pre.test(val);
    }
}
