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
                new Object[]{new BigDecimal(0), 0, new BigDecimal(0)},
                new Object[]{new BigDecimal(0), 1, new BigDecimal(0)},
                new Object[]{new BigDecimal(0), -1, new BigDecimal(0)},
                new Object[]{new BigDecimal(0), -1000, new BigDecimal(0)},
                new Object[]{new BigDecimal(0), 1000, new BigDecimal(0)},
                new Object[]{new BigDecimal(3), 10, new BigDecimal(30)},
                new Object[]{new BigDecimal(0.3), 10, new BigDecimal(3)},
                new Object[]{BigDecimal.valueOf(0.3), 10, BigDecimal.valueOf(3.00)},

        };
    }


}
