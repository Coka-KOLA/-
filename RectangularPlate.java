package com.example.cpp.model;

public class RectangularPlate extends Shape {
    private double length, width;

    public RectangularPlate(double length, double width, double mass) {
        super(mass);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getIx() {
        return (mass / 12.0) * (width * width);
    }

    @Override
    public double getIy() {
        return (mass / 12.0) * (length * length);
    }

    @Override
    public double getIz() {
        return (mass / 12.0) * (length * length + width * width);
    }

    @Override
    public String getDescription() {
        return String.format("Rectangular Plate [L=%.2f, W=%.2f, M=%.2f]", length, width, mass);
    }
}