package com.plural.spring.fundamentals.context;

public class ReflectionUtils {

    public static Object createInstance(String className) {
        try {
            Class<?> cClass = Class.forName(className);
            return cClass.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch ( NoClassDefFoundError | Exception ex) {
            return null;
        }
    }
}