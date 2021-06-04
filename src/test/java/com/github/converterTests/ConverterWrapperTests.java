package com.github.converterTests;

import com.github.converter.ConverterWrapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterWrapperTests {

    ConverterWrapper converterWrapper = new ConverterWrapper();

    // ----------------------------------------
    // <-------------USD TO UAH--------------->
    // ----------------------------------------

    @Test
    public void convertUsdToUahOne() {
        String exp = "1,00 USD = 25,68 UAH";
        String act = converterWrapper.convert(1, "USD", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUsdToUahTwo() {
        String exp = "2,00 USD = 51,35 UAH";
        String act = converterWrapper.convert(2, "USD", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUsdToUahMany() {
        String exp = "25,00 USD = 641,89 UAH";
        String act = converterWrapper.convert(25, "USD", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUsdToUahMuchMany() {
        String exp = "25000,00 USD = 641891,89 UAH";
        String act = converterWrapper.convert(25000, "USD", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUsdToUahZero() {
        String exp = "0,00 USD = 0,00 UAH";
        String act = converterWrapper.convert(0, "USD", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUsdToUahZeroCommission() {
        String exp = "25,00 USD = 675,68 UAH";
        String act = converterWrapper.convert(25, "USD", 0);
        assertEquals(exp, act);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConvertUsdToUahNegativeCommission() {
        String act = converterWrapper.convert(25, "USD", -1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConvertUsdToUahOverCommission() {
        String act = converterWrapper.convert(25, "USD", 500);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConvertUsdToUahNegative() {
        String act = converterWrapper.convert(-25, "USD", 5);
    }
    @Test
    public void unknownCurrency() {
        String exp = "Wrong currency";
        String act = converterWrapper.convert(25, "ABC", 5);
        assertEquals(exp, act);
    }

    // ----------------------------------------
    // <-------------UAH TO USD--------------->
    // ----------------------------------------

    @Test
    public void convertUahToUsdOne() {
        String exp = "1,00 UAH = 0,04 USD";
        String act = converterWrapper.convert(1, "UAH", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUahToUsdTwo() {
        String exp = "2,00 UAH = 0,07 USD";
        String act = converterWrapper.convert(2, "UAH", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUahToUsdMany() {
        String exp = "25,00 UAH = 0,88 USD";
        String act = converterWrapper.convert(25, "UAH", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUahToUsdMuchMany() {
        String exp = "25000,00 UAH = 878,75 USD";
        String act = converterWrapper.convert(25000, "UAH", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUahToUsdZero() {
        String exp = "0,00 UAH = 0,00 USD";
        String act = converterWrapper.convert(0, "UAH", 5);
        assertEquals(exp, act);
    }
    @Test
    public void convertUahToUsdZeroCommission() {
        String exp = "25,00 UAH = 0,92 USD";
        String act = converterWrapper.convert(25, "UAH", 0);
        assertEquals(exp, act);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConvertUahToUsdNegativeCommission() {
        String act = converterWrapper.convert(25, "UAH", -1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConvertUahToUsdOverCommission() {
        String act = converterWrapper.convert(25, "UAH", 500);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ConvertUahToUsdNegative() {
        String act = converterWrapper.convert(-25, "UAH", 5);
    }
}
