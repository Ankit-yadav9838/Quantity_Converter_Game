package com.example.convertergame;

public class LiterToMilliliterConverter extends Converter {
    @Override
    public String getType() {
        return "literToMilliliter";
    }

    @Override
    public double convert(double value) {
        return value * 1000.0;
    }

    @Override
    public String getUnit() {
        return "ml";
    }
}
