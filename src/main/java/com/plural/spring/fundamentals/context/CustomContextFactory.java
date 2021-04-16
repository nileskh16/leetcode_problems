package com.plural.spring.fundamentals.context;

public class CustomContextFactory {

    public static CustomContext createContext(String filePath) {
        return new CustomContextImpl(filePath);
    }
}
