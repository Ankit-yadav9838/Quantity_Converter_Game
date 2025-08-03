package com.example.convertergame;

public class MeterToKilometerConverter extends Converter {
    @Override
    public String getType() {
        return "meterToKilometer";
    }

    @Override
    public double convert(double value) {
        return value / 1000.0;
    }

    @Override
    public String getUnit() {
        return "km";
    }
}
