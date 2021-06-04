package com.github.converterTests;

import com.github.converter.Converter;
import org.junit.Assert;
import org.junit.Test;

public class ConverterTests {

    Converter converter = new Converter();

    // ----------------------------------------
    // <-------------UAH TO USD--------------->
    // ----------------------------------------

    @Test
    public void ConvertUahToUsdOne() {
        double act = converter.UahToUsd(1, 5);
        double exp = 0.03;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUahToUsdTwo() {
        double act = converter.UahToUsd(2, 5);
        double exp = 0.07;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUahToUsdMany() {
        double act = converter.UahToUsd(25, 5);
        double exp = 0.87;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUahToUsdMuchMany() {
        double act = converter.UahToUsd(25000, 5);
        double exp = 878.75;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUahToUsdZero() {
        double act = converter.UahToUsd(0, 5);
        double exp = 0;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUahToUsdZeroCommission() {
        double act = converter.UahToUsd(27.02, 0);
        double exp = 1;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConvertUahToUsdNegativeCommission() {
        double act = converter.UahToUsd(27.02, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConvertUahToUsdOverCommission() {
        double act = converter.UahToUsd(27.02, 200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConvertUahToUsdNegative() {
        double act = converter.UahToUsd(-1, 5);
    }

    // ----------------------------------------
    // <-------------USD TO UAH--------------->
    // ----------------------------------------


    @Test
    public void ConvertUsdToUahOne() {
        double act = converter.UsdToUah(1, 5);
        double exp = 25.67;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUsdToUahTwo() {
        double act = converter.UsdToUah(2, 5);
        double exp = 51.35;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUsdToUahMany() {
        double act = converter.UsdToUah(25, 5);
        double exp = 641.89;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUsdToUahMuchMany() {
        double act = converter.UsdToUah(25000, 5);
        double exp = 641891.89;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUsdToUahZero() {
        double act = converter.UsdToUah(0, 5);
        double exp = 0;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test
    public void ConvertUsdToUahZeroCommission() {
        double act = converter.UsdToUah(1, 0);
        double exp = 27.02;
        Assert.assertEquals(exp, act, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConvertUsdToUahNegativeCommission() {
        double act = converter.UsdToUah(27.02, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConvertUsdToUahOverCommission() {
        double act = converter.UsdToUah(27.02, 200);
    }


    @Test(expected = IllegalArgumentException.class)
    public void ConvertUsdToUahNegative() {
        double act = converter.UsdToUah(-1, 5);
    }
}
