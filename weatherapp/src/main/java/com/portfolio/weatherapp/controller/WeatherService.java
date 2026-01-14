package com.portfolio.weatherapp.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    public final String BASE_URL = "https://api.open-meteo.com/v1/forecast";

    public Map getWeatherByCoordinates(double latitude, double longitude){

        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?latitude=%f&longitude=%f&current_weather=true", BASE_URL, latitude, longitude);
        Map response = restTemplate.getForObject(url, Map.class);

        return response;

    }

}
