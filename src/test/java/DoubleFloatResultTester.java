import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DoubleFloatResultTester {

    @Test
    public void shouldDisplayWrongResultAsItIsDouble() {
        double result = 1.03 - 0.42;
        //should be 0.61
        Assertions.assertEquals(0.6100000000000001, result);
    }

    @Test
    public void shouldDisplayCorrectResultAsItIsBigDecimal() {

        BigDecimal first = new BigDecimal("1.03");
        BigDecimal second = new BigDecimal("0.42");
        BigDecimal result = first.subtract(second);
        Assertions.assertEquals(result, new BigDecimal("0.61"));

    }

    @Test
    public void shouldNotDisplayCorrectItemsBoughtAndFundsDisplay() {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; price <= funds; price += 0.1) {
            funds -= price;
            itemsBought++;
        }
        //should be 0
        Assertions.assertEquals(0.3999999999999999, funds);
        //should be 4 -> 0.10 + 0.20 + 0.30 + 0.40
        Assertions.assertEquals(3, itemsBought);


    }

    @Test
    public void shouldDisplayCorrectItemsBoughtAndFunds() {
        BigDecimal funds = new BigDecimal("1.00");
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;

        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }

        Assertions.assertEquals(new BigDecimal("0.00"), funds);
        Assertions.assertEquals(4, itemsBought);
    }

}
