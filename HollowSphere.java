package com.example.cpp.model;

public class HollowSphere extends Shape {
    private double radius;

    public HollowSphere(double radius, double mass) {
        super(mass);
        this.radius = radius;
    }

    @Override
    public double getIx() {
        return (2.0 / 3.0) * mass * radius * radius;
    }

    @Override
    public double getIy() { return getIx(); }

    @Override
    public double getIz() { return getIx(); }

    @Override
    public String getDescription() {
        return String.format("Hollow Sphere [R=%.2f, M=%.2f]", radius, mass);
    }
}