package pl.bykowski.home52.homework52.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.bykowski.home52.homework52.model.WeatherInfo;


@Service
public class WeatherService {
    private String city = "Katowice";
    public static final String APIKEY = "96af5c9be1cc96d7c2236fdc39ee2777";


    public WeatherInfo getWeatherInfo() {

        RestTemplate restTemplate = new RestTemplate();
        WeatherInfo weatherData = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + getCity() + "&units=metric&appid=" + APIKEY + "&lang=pl",
                WeatherInfo.class);
        return weatherData;

    }

    public String getIcon() {
        String icon = getWeatherInfo().getWeather().get(0).getIcon();
        return "http://openweathermap.org/img/wn/" + icon + "@2x.png";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
