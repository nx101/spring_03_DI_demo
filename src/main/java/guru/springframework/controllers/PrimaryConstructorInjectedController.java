package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class PrimaryConstructorInjectedController {

    private GreetingService greetingService;

    // Will resolve using @Primary at the bean service
    public PrimaryConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return "PrimaryInjectedController " + greetingService.sayGreeting();
    }

}
