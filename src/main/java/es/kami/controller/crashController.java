package es.kami.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class crashController {

    @GetMapping("/error")
    public String triggerException() {
        throw new RuntimeException(this.toString());
    } 

}