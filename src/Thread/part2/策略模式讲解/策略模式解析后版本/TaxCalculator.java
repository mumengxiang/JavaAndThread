package Thread.part2.策略模式讲解.策略模式解析后版本;

public class TaxCalculator {
    //工资
    private final double salary;

    public double getSalary() {
        return salary;
    }

    //奖金
    private final double bonus;
    public double getBonus() {
        return bonus;
    }

    //策略（税率的计算策略）
    private TaxStrategy taxStrategy;
    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }



    //构造函数
    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }
    public TaxCalculator(double salary, double bonus,TaxStrategy taxStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.taxStrategy = taxStrategy;
    }
    //计算税率的函数(使用策略进行计算)
    private Double caclTax(){
        return taxStrategy.getTexCaclulate(salary,bonus);
    }
    //外部接口
    public Double getCaclTex(){
         return  this.caclTax();
    }
}
