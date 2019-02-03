package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.PrimaryConstructorInjectedController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		// by instance
		PrimaryConstructorInjectedController primaryConstructorInjectedController =
				(PrimaryConstructorInjectedController) ctx.getBean("primaryConstructorInjectedController");
		System.out.println(primaryConstructorInjectedController.sayHello());

		// by class (static)
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

	}
}
