package com.github.converter;

public class ConverterWrapper {

    public String convert(double value, String currency, double commission) throws IllegalArgumentException {
        Converter converter = new Converter();
        String res;
        if (value >= 0 && commission >=0 && commission <=100) {
            switch (currency) {
                case "USD":
                    res = String.format("%.2f USD = %.2f UAH", value, converter.UsdToUah(value, commission));
                    return res;
                case "UAH":
                    res = String.format("%.2f UAH = %.2f USD", value, converter.UahToUsd(value, commission));
                    return res;
                default:
                    return "Wrong currency";
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
