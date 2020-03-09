package pl.bykowski.home52.homework52.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bykowski.home52.homework52.service.WeatherService;


@Controller
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;


    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void weatherPrint() {
        System.out.println(weatherService.getWeatherInfo());
        System.out.println(weatherService.getCity());
        System.out.println(weatherService.getIcon());

    }


    @GetMapping
    public String weatherWeb(Model model) {
        model.addAttribute("weather", weatherService.getWeatherInfo());
        model.addAttribute("city", new WeatherService());
        model.addAttribute("icon", weatherService.getIcon());
        return "index";

    }

    @PostMapping("/set-city")
    public String setCityByName(@RequestParam String city) {
        weatherService.setCity(city);
        return "redirect:/weather";
    }


}
