import costs.CostCalculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

import java.math.BigDecimal;


/**
 * Created by Grzegorz Chrzaszczyk on 01-12-2018  12:38 PM
 */

@RunWith(JUnitParamsRunner.class)

public class CostTest {

    @Test
    @Parameters(method = "calcValues")
    public void costTest(BigDecimal unitPrice, int numberOfMessages, BigDecimal expectedValue) {

        CostCalculator costCalc = new CostCalculator(unitPrice);
        Assert.assertEquals(expectedValue, costCalc.calculate(numberOfMessages));
    }


    private Object[] calcValues() {
        return new Object[]{   //unitPrice, numberOfMessages, expectedValue
                //Note: valueOf is not the same as new
                new Object[]{new BigDecimal("0.00"), 0, new BigDecimal("0.00")},
                new Object[]{new BigDecimal("0.00"), 1, new BigDecimal("0.00")},
                new Object[]{new BigDecimal("0.00"), -1, new BigDecimal("0.00")},
                new Object[]{new BigDecimal("0.00"), -1000, new BigDecimal("0.00")},
                new Object[]{new BigDecimal("0.00"), 1000, new BigDecimal("0.00")},
                new Object[]{new BigDecimal("3.00"), 10, new BigDecimal("30.00")},
                new Object[]{new BigDecimal("0.99"), 10, new BigDecimal("9.90")},
                new Object[]{new BigDecimal("-0.33"), 10, new BigDecimal("0.00")},

        };
    }


}
