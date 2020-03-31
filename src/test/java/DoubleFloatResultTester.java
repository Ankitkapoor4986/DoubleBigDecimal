import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DoubleFloatResultTester {

    @Test
    public void shouldDisplayWrongResultAsItIsDouble() {
        double result = 1.03 - 0.42;

        Assertions.assertEquals(0.6100000000000001, result);
    }

    @Test
    public void shouldDisplayCorrectResultAsItIsBigDecimal() {

        BigDecimal first = new BigDecimal("1.03");
        BigDecimal second = new BigDecimal("0.42");
        BigDecimal result = first.subtract(second);
        Assertions.assertEquals(result, new BigDecimal("0.61"));

    }


}
