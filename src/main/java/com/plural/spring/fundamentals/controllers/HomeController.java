package com.plural.spring.fundamentals.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/home")
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Map<String, String> getStatus() {
        Map<String, String> info = new HashMap<>();
        info.put("app-version", appVersion);
        return info;
    }
}