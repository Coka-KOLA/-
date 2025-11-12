package com.example.cpp.model;

public class Cone extends Shape {
    private double height, radius;

    public Cone(double height, double radius, double mass) {
        super(mass);
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double getIx() {
        return (3.0 / 20.0) * mass * (4 * radius * radius + height * height);
    }

    @Override
    public double getIy() {
        return getIx();
    }

    @Override
    public double getIz() {
        return (3.0 / 10.0) * mass * radius * radius;
    }

    @Override
    public String getDescription() {
        return String.format("Cone [H=%.2f, R=%.2f, M=%.2f]", height, radius, mass);
    }
}