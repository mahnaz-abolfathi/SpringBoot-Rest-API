package com.example.firstrestapi.temp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")  // Adjust this to the port where your Vue app is running
public class MyHttpFormController {
    static List<String> names = new ArrayList<>();

    static {
        names.add("Adrina Ahmadi");
    }

    @PostMapping(path = "/add-name")
    public void insertName(@RequestBody FormData data) {
        names.add(data.getName() + " " + data.getFamily());
    }

    @GetMapping(path = "/get-name/{index}")
    public String getName(@PathVariable Integer index) {
        return names.get(index);
    }

    public static class FormData {
        private String name;
        private String family;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFamily() {
            return family;
        }

        public void setFamily(String family) {
            this.family = family;
        }
    }
}
