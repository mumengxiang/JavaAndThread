package Thread.part2.策略模式讲解.原始版本;

public class TaxCalculator {
    //工资
    private final double salary;

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    //奖金
    private final double bonus;

    //构造函数
    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }
    //计算税率的函数
    protected Double caclTax(){
        return 0.0d;
    }
    //外部接口
    public Double getCaclTex(){
         return  this.caclTax();
    }
}
