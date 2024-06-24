package dev.first.runnerz.cardio;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardioController {

 @RequestMapping("/hello")
    String home(){
        return "Welcome to the Cardio Controller";
    }
}
