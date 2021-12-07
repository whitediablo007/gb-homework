package gb.spring.lesson4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping
    public String get() {
        return "OK";
    }
}
