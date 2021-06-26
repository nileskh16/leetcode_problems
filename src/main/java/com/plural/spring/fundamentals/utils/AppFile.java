package com.plural.spring.fundamentals.utils;

public class AppFile {

    private String name;
    private String content;

    public AppFile(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
