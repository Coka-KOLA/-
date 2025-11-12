package com.example.cpp.model;

// Абстрактный базовый класс (инкапсуляция и полиморфизм)
public abstract class Shape {
    protected double mass;

    public Shape(double mass) {
        this.mass = mass;
    }

    public double getMass() { return mass; }
    public void setMass(double mass) { this.mass = mass; }

    // Каждый потомок обязан реализовать метод расчёта моментов инерции
    public abstract double getIx();
    public abstract double getIy();
    public abstract double getIz();

    public abstract String getDescription();
}