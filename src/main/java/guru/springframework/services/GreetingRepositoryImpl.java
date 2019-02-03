package guru.springframework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello - Primary GreetingRepositoryImpl en";
    }

    @Override
    public String getSpanishGreeting() {
        return "Hola - Primary GreetingRepositoryImpl es";
    }

    @Override
    public String getGermanGreeting() {

        return "Grußdienst - Primary GreetingRepositoryImpl de";

    }
}
