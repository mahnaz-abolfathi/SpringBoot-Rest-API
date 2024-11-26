package com.example.firstrestapi.temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

    static List<String> cities = new ArrayList<>();

    static {
       cities.add("Tehran");
       cities.add("Utrecht");
       cities.add("Amsterdam");
       cities.add("Shiraz");
    }

    @GetMapping(path = "/get-city/{code}")
    public String getCityByCode(@PathVariable String code){
        for (String city : cities) {
            if (city.charAt(0) == code.charAt(0)){
                return city;
            }
        }
        return "City is not found!";
    }
}
