package com.plural.spring.fundamentals.annotations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SerializeField {
    private String name;
    private Object value;

    @Override
    public String toString() {
        return String.format("%s: %s,%n", name, value);
    }
}
