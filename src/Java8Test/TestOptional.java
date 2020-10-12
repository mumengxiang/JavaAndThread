package Java8Test;

import Java8Model.emplyee;
import org.junit.Test;

import java.util.Optional;

public class TestOptional {

    /**
     * Optional 容器类的常用方法：
     * Optional.of(T t):创建一个Optional实例
     * Optional.empty():创建一个空的Optional实例
     * Optional.ofNullable(T t) 若t不为null时，创建Optional实例，否则创建空实例
     * isPresent():判断是否包含值
     * orElse(T t): 如果调用对象包含值，返回该值，否则返回t
     * orElseGet(Supplier s):如果调用对象包含值。返回该值，否则返回s获取的值
     * map(Function f):如果有值对其处理，并返回处理后的Optional,否则返回Optional.empty()
     * flatMap(Function mapper):与map类似，要求返回值必须是Optional
     */
    @Test
    public void test(){
        Optional<emplyee> emplyee = Optional.of(new emplyee());
        System.out.println(emplyee.get());
    }

    @Test
    public void test1(){
        Optional<emplyee> emplyee = Optional.empty();
        System.out.println(emplyee.get());
    }

    @Test
    public void test2(){
        Optional<emplyee> emplyee = Optional.ofNullable(null  );
        System.out.println(emplyee.get());
    }

}
