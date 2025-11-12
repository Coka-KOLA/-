package com.example.cpp.model;

public class Cylinder extends Shape {
    private double height, radius;

    public Cylinder(double height, double radius, double mass) {
        super(mass);
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double getIx() {
        return (mass / 12.0) * (3 * radius * radius + height * height);
    }

    @Override
    public double getIy() {
        return getIx();
    }

    @Override
    public double getIz() {
        return 0.5 * mass * radius * radius;
    }

    @Override
    public String getDescription() {
        return String.format("Cylinder [H=%.2f, R=%.2f, M=%.2f]", height, radius, mass);
    }
}