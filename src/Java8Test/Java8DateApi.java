package Java8Test;

import org.junit.Test;

import java.time.*;

public class Java8DateApi {

    //1.LocalDate  日期
    // localTime  时间
    // LocalDateTime 日期和时间
    @Test
    public void tiemTest(){
        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println("**"+dateTime);
        LocalDateTime dateTime2 = LocalDateTime.of(2015, 12, 25,10,12,10);
        System.out.println("**"+dateTime2);

        //对时间进行运算
        //加
        LocalDateTime localDateTime = dateTime.plusMonths(2);
        System.out.println("***"+localDateTime);
        //减
        LocalDateTime localDateTime1 = dateTime.minusMonths(2);
        System.out.println("***"+localDateTime1);
        
        //得到值
        //年
        int year = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        System.out.println("**year**"+year+"**monthValue**"+monthValue);
    }

    //2.时间戳 Instant
    @Test
    public void test2(){
        Instant now = Instant.now();//默认获取UTC时区
        System.out.println("**"+now);
    }

    //3.Duration:计算两个“时间“之间的间隔”
    //  Period:计算两个“日期”之间的间隔
    @Test
    public void test3() throws  Exception{
        //Duration
        Instant now1 = Instant.now();
        Thread.sleep(1000);
        Instant now2 = Instant.now();
        Duration duration = Duration.between(now1, now2);
        System.out.println("***"+duration.getSeconds()+"s");
        System.out.println("-------------------------------------");
        LocalDateTime dateTime1=LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime dateTime2=LocalDateTime.now();
        long millis = Duration.between(dateTime1, dateTime2).toMillis();
        System.out.println("**"+millis);
        //Period
        LocalDate ld1 = LocalDate.of(2015, 10, 2);
        LocalDate ld2=LocalDate.now();
        int days = Period.between(ld1, ld2).getDays();
        System.out.println("**days." +
                "" +
                "**"+days);
    }
}
