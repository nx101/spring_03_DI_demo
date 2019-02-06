package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.PrimaryConstructorInjectedController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// Spring boot app root
@SpringBootApplication

// If we want to override the default spring boot Component Scan,
// of only root and below it (root == package guru.springframework),
// We must explicitly specify all the base packages (base : it and below).
// Like basePackages, we have more options to specify by classes and more
@ComponentScan(basePackages = {"guru.springframework", "guru.external.somepackage"})
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
