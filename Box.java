package com.example.cpp.model;

public class Box extends Shape {
    private double length, width, depth;

    public Box(double length, double width, double depth, double mass) {
        super(mass);
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public double getIx() {
        return (mass / 12.0) * (width * width + depth * depth);
    }

    @Override
    public double getIy() {
        return (mass / 12.0) * (length * length + depth * depth);
    }

    @Override
    public double getIz() {
        return (mass / 12.0) * (length * length + width * width);
    }

    @Override
    public String getDescription() {
        return String.format("Box [L=%.2f, W=%.2f, D=%.2f, M=%.2f]", length, width, depth, mass);
    }
}