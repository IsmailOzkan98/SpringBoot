package dev.ismail.SpringBootStudents.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    private static final String OpenWeatherApiurl = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=ad21d76160cbf5e6962cc15717035bfe";

    @GetMapping("/api/v1/weather")
    public ResponseEntity<String> getWeatherInfo() {
        RestTemplate restTemplate = new RestTemplate();
        String weatherInfo = restTemplate.getForObject(OpenWeatherApiurl, String.class);

        return new ResponseEntity<>(weatherInfo, HttpStatus.OK);
    }
}













