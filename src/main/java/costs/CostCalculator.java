package costs;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  11:41 AM
 */

public class CostCalculator {

    private BigDecimal unitPrice;

    public CostCalculator(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal calculate(Integer smsCount) {

        BigDecimal calc = new BigDecimal("0.00");

        if ((smsCount > 0) && (getUnitPrice().compareTo(BigDecimal.ZERO) >= 0)) {
            calc = getUnitPrice()
                    .setScale(2, RoundingMode.HALF_UP)
                    .multiply(new BigDecimal(smsCount.toString()));
        }
        return calc;
    }

    @Override
    public String toString() {
        return "CostCalculator{" +
                "unitPrice=" + unitPrice +
                '}';
    }
}
