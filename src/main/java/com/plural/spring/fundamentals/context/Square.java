package com.plural.spring.fundamentals.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Square implements Figure {
    private float length;
    private float height;
    private float breadth;

    @Override
    public double getArea() {
        return (length * height);
    }

    @Override
    public double getSurfaceArea() {
        return (length * breadth + length * height + breadth * height);
    }

    @Override
    public double getVolume() {
        return (length * height * breadth);
    }
}
