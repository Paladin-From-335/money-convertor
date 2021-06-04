package com.github.converter;

public class Converter {

   private static final CourseProvider courseProvider = new CourseProvider();

    public Double UsdToUah(double value, double commission) {
        if(value<0 || commission<0 || commission >100) {
            throw new IllegalArgumentException();
        }
        commission = value*(commission/100.0);
        return (value - commission)/courseProvider.COURSE;
    }

    public  Double UahToUsd(double value, double commission) {
        if(value<0 || commission<0 || commission >100) {
            throw new IllegalArgumentException();
        }
        commission = value*(commission/100.0);
        return (value - commission)*courseProvider.COURSE;
    }
}
