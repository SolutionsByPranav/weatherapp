package com.portfolio.weatherapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/api/health")
    public HealthResponse health(){
        return new HealthResponse("OK");
    }

    record HealthResponse(String status) {

    }
}
