package com.plural.spring.fundamentals.annotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class FieldSerializer {
    private final List<SerializeField> fields;

    public FieldSerializer() {
        this.fields = new ArrayList<>();
    }

    public String serializeObject(Object object) throws IllegalAccessException {
        processJsonFields(object);
        return serializedValue();
    }

    private void processJsonFields(Object object) throws IllegalAccessException {
        if (null != object) {
            Class<?> classObject = requireNonNull(object).getClass();
            Field[] objectFields = classObject.getDeclaredFields();
            for (Field field : objectFields) {
                if (field.isAnnotationPresent(JsonFieldInclude.class)) {
                    String annotationValue = field.getDeclaredAnnotation(JsonFieldInclude.class).value();
                    SerializeField serializeField = new SerializeField();
                    serializeField.setName(!annotationValue.equalsIgnoreCase("") ? annotationValue : field.getName());
                    serializeField.setValue(field.get(object));
                    fields.add(serializeField);
                }
            }
        }
    }

    private String serializedValue() {
        StringBuilder sb = new StringBuilder("");
        if (!fields.isEmpty()) {
            sb.append("{\n");
            for (SerializeField field : fields) {
                sb.append(field.toString());
            }
            sb.append("}");
        }
        return sb.toString();
    }
}