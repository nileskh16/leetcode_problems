package com.plural.spring.fundamentals.context;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CustomContext {
    Object getBean(String beanName);
    void loadContext() throws FileNotFoundException, IOException, Exception;
}
