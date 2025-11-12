package com.example.cpp.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.cpp.model.*;

public class ShapeView extends View {
    private Shape shape;
    private Paint paint;

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(4f);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (shape == null) return;

        float w = getWidth();
        float h = getHeight();
        float cx = w / 2;
        float cy = h / 2;
        float size = Math.min(w, h) / 3;

        if (shape instanceof Box) {
            canvas.drawRect(cx - size, cy - size/2, cx + size, cy + size/2, paint);
        } else if (shape instanceof Cylinder) {
            canvas.drawOval(new RectF(cx - size, cy - size, cx + size, cy + size), paint);
        } else if (shape instanceof Sphere) {
            canvas.drawCircle(cx, cy, size, paint);
        } else if (shape instanceof HollowSphere) {
            paint.setStrokeWidth(3);
            canvas.drawCircle(cx, cy, size, paint);
            paint.setStrokeWidth(1);
            canvas.drawCircle(cx, cy, size * 0.7f, paint);
            paint.setStrokeWidth(4);
        } else if (shape instanceof HollowCylinder) {
            paint.setStrokeWidth(3);
            canvas.drawOval(new RectF(cx - size, cy - size, cx + size, cy + size), paint);
            paint.setStrokeWidth(1);
            canvas.drawOval(new RectF(cx - size * 0.7f, cy - size * 0.7f, cx + size * 0.7f, cy + size * 0.7f), paint);
            paint.setStrokeWidth(4);
        } else if (shape instanceof Cone) {
            canvas.drawLine(cx - size, cy + size, cx, cy - size, paint);
            canvas.drawLine(cx + size, cy + size, cx, cy - size, paint);
            canvas.drawArc(new RectF(cx - size, cy + size - 20, cx + size, cy + size + 20),
                    0, 180, false, paint);
        } else if (shape instanceof RectangularPlate) {
            canvas.drawRect(cx - size, cy - size/4, cx + size, cy + size/4, paint);
        }
    }}