package Java8Test;

import Java8Model.emplyee;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用方法引用
 *  三种格式：
 *  对象::实例方法名
 *
 *  类::静态方法名
 *
 *  对象::实例方法名
 *
 * 注：Lambda体中调用方法的参数列表和返回值类型，要与函数式接口中的抽象方法的函数列表和返回值类型保持一致。
 */
public class 方法引用 {

    public static void main(String[] args) {
//        Consumer<String> conn=(x)-> System.out.println("x");
        //对象::实例方法名
        PrintStream out = System.out;
        Consumer<String> conn1=out::println;
        conn1.accept("123");

        emplyee e=new emplyee();
        Supplier<String> sup=e::getName;
        String name = sup.get();
        System.out.println("**"+name);

        //类::静态方法名
        Comparator<Integer> conn=(x,y)->Integer.compare(x,y);
        int i = conn.compare(2, 1);
        System.out.println("**"+i);
        Comparator<Integer> conn2=Integer::compare;

    }
}
