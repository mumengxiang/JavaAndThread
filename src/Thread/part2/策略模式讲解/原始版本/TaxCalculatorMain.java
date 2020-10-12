package Thread.part2.策略模式讲解.原始版本;

public class TaxCalculatorMain {

    public static void main(String[] args) {
        //初始化
        TaxCalculator taxCalculator=new TaxCalculator(10000,2000){
            //使用匿名内部类
            @Override
            public Double caclTax() {
                return  getSalary()*0.1+getBonus()*0.1;
            }
        };
        Double total = taxCalculator.getCaclTex();
        System.out.println(total);

    }

}
