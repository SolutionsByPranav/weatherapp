package com.portfolio.weatherapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/health")
    public Map<String, String> health(){
        return Map.of("Status", "OK");
    }

    //New endpoint: latitude and longitude
    @GetMapping("/api/health/{lat}/{long}")
    public Map getWeather(
            @PathVariable("lat") double latitude,
            @PathVariable("long") double longitude
    ){

        return weatherService.getWeatherByCoordinates(latitude, longitude);
    }
}


