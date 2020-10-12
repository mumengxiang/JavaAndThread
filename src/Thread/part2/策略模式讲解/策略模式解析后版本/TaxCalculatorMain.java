package Thread.part2.策略模式讲解.策略模式解析后版本;

public class TaxCalculatorMain {

    public static void main(String[] args) {
        //初始化taxCalculator
        TaxCalculator taxCalculator=new TaxCalculator(10000,2000);
        //初始化策略
        TaxStrategy taxStrategy=new TaxStrategyImpl();
        //注入策略
        taxCalculator.setTaxStrategy(taxStrategy);
        //求出计算结果
        Double result = taxCalculator.getCaclTex();
        System.out.println("*********"+result);

        //使用javc8进行改造
        TaxCalculator taxCalculator1=new TaxCalculator(10000,2000, (s,b)->s*0.1+b*0.1);
        Double result1 = taxCalculator1.getCaclTex();
        System.out.println("------------"+result1);

    }

}
