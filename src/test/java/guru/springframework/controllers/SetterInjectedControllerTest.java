package guru.springframework.controllers;

import guru.springframework.services.PropertyGreetingService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jt on 5/24/17.
 */
public class SetterInjectedControllerTest {

    private SetterInjectedController setterInjectedController;

    @Before
    public void setUp() throws Exception {
        this.setterInjectedController = new SetterInjectedController();
        this.setterInjectedController.setGreetingService(new PropertyGreetingService());
    }

    @Test
    public void testGreeting() throws Exception {
        assertEquals(PropertyGreetingService.HELLO_GREET, setterInjectedController.sayHello());
    }
}