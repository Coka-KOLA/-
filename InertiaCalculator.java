package com.example.cpp.util;

import com.example.cpp.model.Shape;

public class InertiaCalculator {

    public static String compute(Shape shape) {
        double Ix = shape.getIx();
        double Iy = shape.getIy();
        double Iz = shape.getIz();

        return String.format("Shape: %s\nIx = %.5f\nIy = %.5f\nIz = %.5f",
                shape.getDescription(), Ix, Iy, Iz);
    }
}