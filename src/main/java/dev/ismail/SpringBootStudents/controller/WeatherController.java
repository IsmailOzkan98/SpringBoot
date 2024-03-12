package dev.ismail.SpringBootStudents.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class WeatherController {


    static final String API_KEY = "ad21d76160cbf5e6962cc15717035bfe";


    //private static final String OpenWeatherApiurl = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=ad21d76160cbf5e6962cc15717035bfe";
    //private static final String OpenWeatherApiurl = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&appid="+API_KEY;

    @GetMapping("/api/v1/weather")
    public ResponseEntity<Map> getWeatherInfo(
            @RequestParam String city,
            @RequestParam String country) {

        String OpenWeatherApiURL = "https://api.openweathermap.org/data/2.5/weather?q="+ city +","+ country +"&appid="+API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        Map weatherInfo = restTemplate.getForObject(OpenWeatherApiURL, Map.class);

        return new ResponseEntity<>(weatherInfo, HttpStatus.OK);
    }
}












