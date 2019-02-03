package guru.springframework.services;

import org.springframework.stereotype.Service;


@Service
public class PropertyGreetingService implements GreetingService {

    public final static String HELLO_GREET = "Hello - PropertyGreetingService"; // so it can be tested

    @Override
    public String sayGreeting() {
        return HELLO_GREET;
    }
}
