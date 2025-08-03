package com.example.convertergame;

public abstract class Converter {
    public abstract String getType();

    public abstract double convert(double value);

    public abstract String getUnit();
}
