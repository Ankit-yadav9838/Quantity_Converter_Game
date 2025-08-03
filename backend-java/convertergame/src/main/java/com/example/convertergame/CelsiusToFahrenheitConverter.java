package com.example.convertergame;

public class CelsiusToFahrenheitConverter extends Converter {
    @Override
    public String getType() {
        return "celsiusToFahrenheit";
    }

    @Override
    public double convert(double value) {
        return (value * 9.0 / 5.0) + 32.0;
    }

    @Override
    public String getUnit() {
        return "°F";
    }
}
