package Thread.part2.策略模式讲解.策略模式解析后版本;

/**
 * 这里是策略模式实现类
 */
public class TaxStrategyImpl  implements TaxStrategy{
    //工资和奖金的税率
    private final  static  double  salay_rate=0.1;
    private final  static  double   bonus_rate=0.1;
    @Override
    public double getTexCaclulate(Double salay, Double bonus) {
        return salay*salay_rate+bonus*bonus_rate;
    }
}
