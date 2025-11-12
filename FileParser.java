package com.example.cpp.util;

import android.net.Uri;
import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.example.cpp.model.*;

public class FileParser {

    public static class ShapeData {
        public String type;
        public double p1, p2, p3, mass;
    }

    public static ShapeData parse(Context context, Uri uri) throws Exception {
        InputStream inputStream = context.getContentResolver().openInputStream(uri);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        ShapeData data = new ShapeData();

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.toLowerCase().trim();
            if (line.startsWith("#") || line.isEmpty()) continue;

            if (line.contains(":")) {
                String[] parts = line.split(":");
                if (parts.length < 2) continue;
                String key = parts[0].trim();
                String value = parts[1].replaceAll("[^0-9.]", "").trim();

                if (key.contains("shape")) data.type = value;
                else if (key.contains("length") || key.contains("height")) data.p1 = Double.parseDouble(value);
                else if (key.contains("width") || key.contains("diameter")) data.p2 = Double.parseDouble(value);
                else if (key.contains("depth")) data.p3 = Double.parseDouble(value);
                else if (key.contains("mass")) data.mass = Double.parseDouble(value);
            }
        }
        reader.close();
        return data;
    }

    public static Shape buildShape(ShapeData d) {
        if (d.type == null) return null;
        String type = d.type.toLowerCase();

        switch (type) {
            case "box": return new Box(d.p1, d.p2, d.p3, d.mass);
            case "cylinder": return new Cylinder(d.p1, d.p2 / 2, d.mass);
            case "sphere": return new Sphere(d.p1 / 2, d.mass);
            case "hollowsphere": return new HollowSphere(d.p1 / 2, d.mass);
            case "hollowcylinder": return new HollowCylinder(d.p1, d.p2 / 2, d.mass);
            case "cone": return new Cone(d.p1, d.p2 / 2, d.mass);
            case "rectangularplate": return new RectangularPlate(d.p1, d.p2, d.mass);
            default: return null;
        }
    }
}