package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class PropertyInjectedController {

    // Property Injection - NOT recommended, uses costly reflection
    // Spring uses both property Class AND Name to resolve deps
    //  will use reflection to resolve
    @Autowired
    @Qualifier("propertyGreetingService")
    public GreetingService greetingServiceImpl;

    public String sayHello(){
        return "PropertyInjectedController " + greetingServiceImpl.sayGreeting();
    }

}
