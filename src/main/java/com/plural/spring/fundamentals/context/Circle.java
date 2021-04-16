package com.plural.spring.fundamentals.context;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Circle implements Figure {
    private float radius;
    private float height;

    public void setRadius(float radius) {
        this.radius = radius >= 1 ? radius : 0;
    }

    public void setHeight(float height) {
        this.height = height >= 1 ? height : 0;
    }

    @Override
    public double getArea() {
        return (Math.PI * radius * radius);
    }

    @Override
    public double getSurfaceArea() {
        return (2 * Math.PI * radius * height);
    }

    @Override
    public double getVolume() {
        return (Math.PI * Math.pow(radius, 3));
    }
}
